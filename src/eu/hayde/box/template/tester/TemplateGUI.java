package eu.hayde.box.template.tester;

import eu.hayde.box.template.Template;
import eu.hayde.box.template.TemplateException;
import eu.hayde.box.template.xml.XMLException;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author can.senturk
 */
public class TemplateGUI extends javax.swing.JFrame {

	/*
	 * Create the file choosers
	 */
	private JFileChooser fcBaseDir = new JFileChooser();
	private JFileChooser fcTemplate = new JFileChooser();
	private JFileChooser fcXML = new JFileChooser();
	private JFileChooser fcOuput = new JFileChooser();
	private Long templateFileSize = null;
	private Timer theTimer = null;
	private TimerTask theTimerTask = null;

	/**
	 * Creates new form TemplateGUI
	 */
	public TemplateGUI() {
		initComponents();

		getContentPane().setBackground(Color.WHITE);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBaseDir = new javax.swing.JLabel();
        txtBaseDir = new javax.swing.JTextField();
        lblTemplate = new javax.swing.JLabel();
        txtTemplate = new javax.swing.JTextField();
        lblXML = new javax.swing.JLabel();
        txtXML = new javax.swing.JTextField();
        lblOutput = new javax.swing.JLabel();
        txtOutput = new javax.swing.JTextField();
        chkAuto = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtError = new javax.swing.JTextArea();
        lblError = new javax.swing.JLabel();
        btnBaseDir = new javax.swing.JLabel();
        btnTemplate = new javax.swing.JLabel();
        btnXML = new javax.swing.JLabel();
        btnOutput = new javax.swing.JLabel();
        btnProcess = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("hayde Template Tester Version 0.5");
        setBackground(new java.awt.Color(255, 255, 255));

        lblBaseDir.setText("BaseDir");

        txtBaseDir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTemplate.setText("Template location");

        txtTemplate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblXML.setText("XML data location");

        txtXML.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblOutput.setText("Output file");

        txtOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutputActionPerformed(evt);
            }
        });

        chkAuto.setBackground(new java.awt.Color(255, 255, 255));
        chkAuto.setText("Recreate output if template is changed?");
        chkAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutoActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtError.setColumns(20);
        txtError.setRows(5);
        jScrollPane1.setViewportView(txtError);

        lblError.setText("Error Msg:");

        btnBaseDir.setBackground(new java.awt.Color(102, 102, 102));
        btnBaseDir.setForeground(new java.awt.Color(255, 255, 255));
        btnBaseDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBaseDir.setText("Browse");
        btnBaseDir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBaseDir.setOpaque(true);
        btnBaseDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBaseDirClicked(evt);
            }
        });

        btnTemplate.setBackground(new java.awt.Color(102, 102, 102));
        btnTemplate.setForeground(new java.awt.Color(255, 255, 255));
        btnTemplate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTemplate.setText("Browse");
        btnTemplate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTemplate.setOpaque(true);
        btnTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTemplateClicked(evt);
            }
        });

        btnXML.setBackground(new java.awt.Color(102, 102, 102));
        btnXML.setForeground(new java.awt.Color(255, 255, 255));
        btnXML.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXML.setText("Browse");
        btnXML.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnXML.setOpaque(true);
        btnXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXMLClick(evt);
            }
        });

        btnOutput.setBackground(new java.awt.Color(102, 102, 102));
        btnOutput.setForeground(new java.awt.Color(255, 255, 255));
        btnOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOutput.setText("Browse");
        btnOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnOutput.setOpaque(true);
        btnOutput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOutputClicked(evt);
            }
        });

        btnProcess.setBackground(new java.awt.Color(102, 0, 0));
        btnProcess.setForeground(new java.awt.Color(255, 255, 255));
        btnProcess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProcess.setText("Process");
        btnProcess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnProcess.setOpaque(true);
        btnProcess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcessClicked(evt);
            }
        });

        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eu/hayde/box/template/tester/resource/hayde_logo_small.png"))); // NOI18N
        lblPicture.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1))
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(lblTemplate)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(lblOutput)
                                        .add(lblXML)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(txtTemplate)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(btnTemplate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(txtOutput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(btnOutput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(txtXML, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(btnXML, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(119, 119, 119)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(chkAuto)
                                            .add(layout.createSequentialGroup()
                                                .add(29, 29, 29)
                                                .add(lblError))))
                                    .add(layout.createSequentialGroup()
                                        .add(lblBaseDir)
                                        .add(72, 72, 72)
                                        .add(txtBaseDir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(btnProcess, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(btnBaseDir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblPicture, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(lblPicture, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .add(28, 28, 28))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblBaseDir)
                            .add(btnBaseDir)
                            .add(txtBaseDir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblTemplate)
                            .add(txtTemplate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnTemplate))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblXML)
                            .add(txtXML, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnXML))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblOutput)
                            .add(txtOutput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnOutput))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(chkAuto)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lblError))
                            .add(btnProcess, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 342, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTemplateClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTemplateClicked
		//In response to a button click:
		int returnVal = fcTemplate.showOpenDialog(TemplateGUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fcTemplate.getSelectedFile();

			/*
			 * open this file
			 */
			txtTemplate.setText(file.getAbsolutePath());
		} else {
			/*
			 * do nothing, the user canceled the opening
			 */
		}
    }//GEN-LAST:event_btnTemplateClicked

    private void btnXMLClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXMLClick
		//In response to a button click:
		int returnVal = fcXML.showOpenDialog(TemplateGUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fcXML.getSelectedFile();

			/*
			 * open this file
			 */
			txtXML.setText(file.getAbsolutePath());
		} else {
			/*
			 * do nothing, the user canceled the opening
			 */
		}
    }//GEN-LAST:event_btnXMLClick

    private void btnOutputClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutputClicked
		//In response to a button click:
		int returnVal = fcOuput.showSaveDialog(TemplateGUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fcOuput.getSelectedFile();

			/*
			 * open this file
			 */
			txtOutput.setText(file.getAbsolutePath());
		} else {
			/*
			 * do nothing, the user canceled the opening
			 */
		}
    }//GEN-LAST:event_btnOutputClicked

    private void btnProcessClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProcessClicked
		/*
		 * 1. load the data
		 * 2. load the template
		 * 3. process it
		 */

		txtError.setText("");

		// 1. load the data
		File xml = new File(txtXML.getText());
		Dictionary dict = null;
		Template template = null;
		File output = new File(txtOutput.getText());
		int actions = 0;

		try {
			dict = new Dictionary(xml);
		} catch (ParserConfigurationException ex) {
			txtError.setText("Loading data: " + ex.getMessage());
		} catch (SAXException ex) {
			txtError.setText("Loading data: " + ex.getMessage());
		} catch (IOException ex) {
			txtError.setText("Loading data: " + ex.getMessage());
		} catch (Exception ex) {
			txtError.setText("Loading data: " + ex.getMessage());
		}

		if (dict != null) {
			/*
			 * load the template
			 */
			File templateFile = new File(txtTemplate.getText());
			try {
				template = new Template("", txtBaseDir.getText(), templateFile.toURI().normalize().toString());
				//template = new Template("file:/Users/senturk/Downloads/Sokhom/20130622/", "../search_withTags.html");
				template.setDictionary(dict.getElements());
				actions = template.process();
			} catch (TemplateException ex) {
				txtError.setText("processing template: " + ex.getMessage());
				template = null;
			} catch (XMLException ex) {
				txtError.setText("processing template: " + ex.getMessage());
				template = null;
			}
		}

		if (template != null) {
			/*
			 * write to the output file
			 */
			try {
				BufferedWriter outputBuffer = new BufferedWriter(new FileWriter(output));
				outputBuffer.write(template.getContent());
				outputBuffer.close();

			} catch (Exception ex) {
				txtError.setText("writing file: " + ex.getMessage());
				template = null;
			}
		}

		if (txtError.getText().length() == 0) {
			lblError.setText("Output with " + actions + " actions.");
			txtError.setText(template.getContent());
		} else {
			lblError.setText("Error message");
		}



    }//GEN-LAST:event_btnProcessClicked

    private void chkAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutoActionPerformed
		// and now, if the thing is checked, ...
		if (chkAuto.isSelected()) {

			theTimer = new Timer();
			theTimerTask = new TimerTask() {
				@Override
				public void run() {
					/*
					 * here, we test if the file has changed or not
					 */
					if (fcTemplate.getSelectedFile() != null) {
						File currentFile = null;
						Long currentModificationTime = null;
						try {
							currentFile = new File(fcTemplate.getSelectedFile().getCanonicalPath());
							currentModificationTime = currentFile.lastModified();
						} catch (IOException ex) {
						}

						if (templateFileSize == null) {
							templateFileSize = fcTemplate.getSelectedFile().lastModified();
						}
						if (!templateFileSize.equals(currentModificationTime)) {
							btnProcessClicked(null);
							templateFileSize = currentModificationTime;
						}
					}
				}
			};

			theTimer.schedule(theTimerTask, 500, 500);
		} else {
			/*
			 * cancel the timers
			 */
			theTimerTask.cancel();
			theTimer.cancel();
			theTimer.purge();
		}
    }//GEN-LAST:event_chkAutoActionPerformed

    private void txtOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutputActionPerformed

    private void btnBaseDirClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaseDirClicked
       //In response to a button click:
	   fcBaseDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnVal = fcBaseDir.showOpenDialog(TemplateGUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fcBaseDir.getSelectedFile();

			/*
			 * open this file
			 */
			txtBaseDir.setText(file.getAbsolutePath());
		} else {
			/*
			 * do nothing, the user canceled the opening
			 */
		}
    }//GEN-LAST:event_btnBaseDirClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TemplateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TemplateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TemplateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TemplateGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TemplateGUI().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBaseDir;
    private javax.swing.JLabel btnOutput;
    private javax.swing.JLabel btnProcess;
    private javax.swing.JLabel btnTemplate;
    private javax.swing.JLabel btnXML;
    private javax.swing.JCheckBox chkAuto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBaseDir;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblTemplate;
    private javax.swing.JLabel lblXML;
    private javax.swing.JTextField txtBaseDir;
    private javax.swing.JTextArea txtError;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JTextField txtTemplate;
    private javax.swing.JTextField txtXML;
    // End of variables declaration//GEN-END:variables
}
