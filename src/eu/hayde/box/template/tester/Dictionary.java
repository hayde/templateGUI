package eu.hayde.box.template.tester;

import eu.hayde.box.template.util.NamedHashMap;
import eu.hayde.box.template.converters.StringConverter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * this is the dictionary class, which will carry all variable information
 * parsed from the xml structure we received before.
 *
 * @author can.senturk
 * @version 2013-06-18
 */
public class Dictionary {

	HashMap<String, Object> dictionaryElements = new HashMap<String, Object>();

	public Dictionary(File xmlFile) throws ParserConfigurationException, SAXException, IOException {

		/*
		 * load and parse the file
		 */
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		/* optional, but not recommended in our case!!!
		 * read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		 */
		//doc.getDocumentElement().normalize();

		NodeList root = doc.getChildNodes();

		_addElements(root, dictionaryElements);

	}

	public HashMap getElements() {
		return (HashMap) this.dictionaryElements.get("Dictionary");
	}

	private void _addElements(NodeList nList, Object elements) {

		Object value = null;

		for (int i = 0; i < nList.getLength(); i++) {
			Node item = nList.item(i);
			boolean hasElements = false;

			if (item instanceof Element == false) {
				continue;
			}

			/*
			 * check, if this item has further elements.
			 */
			if (item.hasChildNodes()) {
				NodeList childElements = item.getChildNodes();
				for (int j = 0; j < childElements.getLength(); j++) {
					if (childElements.item(j) instanceof Element) {
						hasElements = true;
						break;
					}
				}
			}

			if (!hasElements) {
				/*
				 * if no children, we will simply add this item to our hash map
				 */
				String javaObject = item.getAttributes().getNamedItem("javaObject").getNodeValue();

				if (javaObject.equals("java.util.ArrayList")
						|| javaObject.equals("java.util.List")) {

					/*
					 * then, we will load them into a new array list
					 */
					value = new ArrayList();
				} else {
					value = _getNodeValue(item);

				}
			} else {
				/*
				 * if there are children, we differentiate array lists, hash maps
				 * and objects.
				 *
				 * since we are not able to recreate objects, we will use a trick
				 * trick, that will enable the bsh interpreter (thanks to our
				 * changes!!!), to read the information from a NamedHashMap.
				 */
				String javaObject = item.getAttributes().getNamedItem("javaObject").getNodeValue();

				if (javaObject.equals("java.util.ArrayList")
						|| javaObject.equals("java.util.List")) {

					/*
					 * then, we will load them into a new array list
					 */
					value = new ArrayList();
					_addElements(item.getChildNodes(), value);


				} else if (javaObject.equals("java.util.HashMap")) {
					/*
					 * we may put them all into a hash map
					 */
					value = new HashMap<String, Object>();
					_addElements(item.getChildNodes(), value);


				} else {
					/*
					 * it has to be an object, so place them to a NamedHashMap
					 */
					value = new NamedHashMap(item.getNodeName());
					_addElements(item.getChildNodes(), value);


				}
			}
			/*
			 * now add this single values to the list
			 */
			if (elements instanceof HashMap) {
				((HashMap) elements).put(item.getNodeName(), value);
			} else if (elements instanceof NamedHashMap) {
				((NamedHashMap) elements).put(item.getNodeName(), value);
			} else if (elements instanceof ArrayList) {
				((ArrayList) elements).add(value);
			}
		}

	}

	private Object _getNodeValue(Node item) {
		Object returnValue = null;
		String javaObject = item.getAttributes().getNamedItem("javaObject").getNodeValue();
		String objectValue = item.getTextContent();

		if (javaObject.equals("java.lang.Long")) {
			returnValue = Long.parseLong(objectValue);
		} else if (javaObject.equals("java.lang.Integer")) {
			returnValue = Integer.parseInt(objectValue);
		} else if (javaObject.equals("java.util.Date")) {
			StringConverter sc = new StringConverter(null);
			returnValue = sc.StringToDate(objectValue);
		} else if (javaObject.equals("java.lang.Double")) {
			returnValue = Double.parseDouble(objectValue);
		} else if (javaObject.equals("java.lang.Boolean")) {
			returnValue = Boolean.parseBoolean(objectValue);
		} else if (javaObject.equals("null")) {
			returnValue = null;
		} else {
			returnValue = objectValue;
		}

		return returnValue;
	}
}
