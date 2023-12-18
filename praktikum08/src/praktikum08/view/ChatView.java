/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package praktikum08.view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Leon
 */
public class ChatView extends javax.swing.JFrame
{

  /**
   * @return the ServerCheckbox
   */
  public javax.swing.JCheckBox getServerCheckbox()
  {
    return ServerCheckbox;
  }

  /**
   * Creates new form ChatView
   */
  public ChatView()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChatPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inputField = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        ControlsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfIP = new javax.swing.JFormattedTextField();
        btnConnect = new javax.swing.JToggleButton();
        ServerCheckbox = new javax.swing.JCheckBox();
        graphicViewer1 = new praktikum08.view.GraphicViewer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChatPanel.setLayout(new javax.swing.BoxLayout(ChatPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        inputField.setText("input");
        inputField.setMinimumSize(new java.awt.Dimension(200, 23));
        inputField.setPreferredSize(new java.awt.Dimension(350, 23));
        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });
        jPanel2.add(inputField);

        SendButton.setText("Send");
        jPanel2.add(SendButton);

        ChatPanel.add(jPanel2);

        ControlsPanel.setMaximumSize(new java.awt.Dimension(500, 23));
        ControlsPanel.setMinimumSize(new java.awt.Dimension(200, 23));
        ControlsPanel.setName(""); // NOI18N
        ControlsPanel.setPreferredSize(new java.awt.Dimension(100, 23));
        ControlsPanel.setLayout(new java.awt.GridLayout(1, 2));
        ChatPanel.add(ControlsPanel);

        getContentPane().add(ChatPanel, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        tfIP.setText("IP-Adress");
        tfIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIPActionPerformed(evt);
            }
        });
        jPanel1.add(tfIP);

        btnConnect.setText("connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        jPanel1.add(btnConnect);

        ServerCheckbox.setText("Act as Server");
        ServerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerCheckboxActionPerformed(evt);
            }
        });
        jPanel1.add(ServerCheckbox);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(graphicViewer1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void ServerCheckboxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ServerCheckboxActionPerformed
  {//GEN-HEADEREND:event_ServerCheckboxActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ServerCheckboxActionPerformed

    private void tfIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIPActionPerformed

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFieldActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConnectActionPerformed

    public GraphicViewer getGraphicViewer() {
        return graphicViewer1;
    }


    public JButton getSendButton() {
        return SendButton;
    }

    public JToggleButton getBtnConnect() {
        return btnConnect;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JFormattedTextField getTfIP() {
        return tfIP;
    }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new ChatView().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChatPanel;
    private javax.swing.JPanel ControlsPanel;
    private javax.swing.JButton SendButton;
    private javax.swing.JCheckBox ServerCheckbox;
    private javax.swing.JToggleButton btnConnect;
    private praktikum08.view.GraphicViewer graphicViewer1;
    private javax.swing.JTextField inputField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField tfIP;
    // End of variables declaration//GEN-END:variables
}
