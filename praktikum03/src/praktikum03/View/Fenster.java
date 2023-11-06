/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package praktikum03.View;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;

/**
 *
 * @author Sebastian Mayer und Leon Bartle
 */
public class Fenster extends javax.swing.JFrame {

    /**
     * Creates new form Fenster
     */
    public Fenster() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    TablePopUp = new javax.swing.JPopupMenu();
    Remove = new javax.swing.JMenuItem();
    Add = new javax.swing.JMenuItem();
    jFileChooser = new javax.swing.JFileChooser();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jToolBar1 = new javax.swing.JToolBar();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    FileName = new javax.swing.JLabel();
    Hauptmenu = new javax.swing.JMenuBar();
    File = new javax.swing.JMenu();
    Open = new javax.swing.JMenuItem();
    Save = new javax.swing.JMenuItem();
    SaveAs = new javax.swing.JMenuItem();
    Exit = new javax.swing.JMenuItem();
    Edit = new javax.swing.JMenu();
    AddEntry = new javax.swing.JMenuItem();
    RemoveEntry = new javax.swing.JMenuItem();

    Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Remove16.gif"))); // NOI18N
    Remove.setText("Remove");
    Remove.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        RemoveActionPerformed(evt);
      }
    });
    TablePopUp.add(Remove);

    Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Edit16.gif"))); // NOI18N
    Add.setText("Add");
    TablePopUp.add(Add);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String []
      {
        "Vorname", "Nachname", "Adresse", "TelNr."
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex)
      {
        return types [columnIndex];
      }
    });
    jTable1.setComponentPopupMenu(TablePopUp);
    jScrollPane1.setViewportView(jTable1);

    getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

    jToolBar1.setRollover(true);

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Save24.gif"))); // NOI18N
    jButton1.setToolTipText("Speichern");
    jButton1.setFocusable(false);
    jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(jButton1);

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Remove24.gif"))); // NOI18N
    jButton2.setToolTipText("Löschen");
    jButton2.setFocusable(false);
    jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton2ActionPerformed(evt);
      }
    });
    jToolBar1.add(jButton2);

    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/RowInsertAfter24.gif"))); // NOI18N
    jButton3.setToolTipText("Insert Entry");
    jButton3.setFocusable(false);
    jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton3.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton3ActionPerformed(evt);
      }
    });
    jToolBar1.add(jButton3);

    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/RowDelete24.gif"))); // NOI18N
    jButton4.setToolTipText("Remove Entry");
    jButton4.setFocusable(false);
    jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(jButton4);

    getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

    FileName.setText("ContactList.csv");
    getContentPane().add(FileName, java.awt.BorderLayout.PAGE_END);

    File.setMnemonic('F');
    File.setText("File");
    File.setComponentPopupMenu(TablePopUp);
    File.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseReleased(java.awt.event.MouseEvent evt)
      {
        FileMouseReleased(evt);
      }
    });

    Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Open16.gif"))); // NOI18N
    Open.setText("Open");
    Open.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseReleased(java.awt.event.MouseEvent evt)
      {
        OpenMouseReleased(evt);
      }
    });
    File.add(Open);

    Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Save16.gif"))); // NOI18N
    Save.setText("Save");
    File.add(Save);

    SaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/SaveAs16.gif"))); // NOI18N
    SaveAs.setText("Save As");
    SaveAs.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseReleased(java.awt.event.MouseEvent evt)
      {
        SaveAsMouseReleased(evt);
      }
    });
    File.add(SaveAs);

    Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Stop16.gif"))); // NOI18N
    Exit.setText("Exit");
    Exit.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseReleased(java.awt.event.MouseEvent evt)
      {
        ExitMouseReleased(evt);
      }
    });
    File.add(Exit);

    Hauptmenu.add(File);

    Edit.setMnemonic('E');
    Edit.setText("Edit");

    AddEntry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/RowInsertAfter16.gif"))); // NOI18N
    AddEntry.setText("Add Entry");
    AddEntry.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        AddEntryActionPerformed(evt);
      }
    });
    Edit.add(AddEntry);

    RemoveEntry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikum03/View/icons/Remove16.gif"))); // NOI18N
    RemoveEntry.setText("Remove Entry");
    RemoveEntry.setToolTipText("");
    Edit.add(RemoveEntry);

    Hauptmenu.add(Edit);

    setJMenuBar(Hauptmenu);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveActionPerformed


    private void FileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileMouseReleased
    }//GEN-LAST:event_FileMouseReleased

  private void OpenMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_OpenMouseReleased
  {//GEN-HEADEREND:event_OpenMouseReleased

  }//GEN-LAST:event_OpenMouseReleased

  private void SaveAsMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SaveAsMouseReleased
  {//GEN-HEADEREND:event_SaveAsMouseReleased

  }//GEN-LAST:event_SaveAsMouseReleased

  private void ExitMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ExitMouseReleased
  {//GEN-HEADEREND:event_ExitMouseReleased

  }//GEN-LAST:event_ExitMouseReleased

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_jButton3ActionPerformed

  private void AddEntryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AddEntryActionPerformed
  {//GEN-HEADEREND:event_AddEntryActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_AddEntryActionPerformed

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
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenster().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem Add;
  private javax.swing.JMenuItem AddEntry;
  private javax.swing.JMenu Edit;
  private javax.swing.JMenuItem Exit;
  private javax.swing.JMenu File;
  private javax.swing.JLabel FileName;
  private javax.swing.JMenuBar Hauptmenu;
  private javax.swing.JMenuItem Open;
  private javax.swing.JMenuItem Remove;
  private javax.swing.JMenuItem RemoveEntry;
  private javax.swing.JMenuItem Save;
  private javax.swing.JMenuItem SaveAs;
  private javax.swing.JPopupMenu TablePopUp;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JFileChooser jFileChooser;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JToolBar jToolBar1;
  // End of variables declaration//GEN-END:variables

    public JMenuItem getAdd() {
        return Add;
    }

    public JMenuItem getAddEntry() {
        return AddEntry;
    }

    public JMenu getEdit() {
        return Edit;
    }

    public JMenuItem getRemoveEntry() {
        return RemoveEntry;
    }

    public JMenuItem getExit() {
        return Exit;
    }

    public JMenu getFile() {
        return File;
    }

    public JLabel getFileName() {
        return FileName;
    }

    public JMenuItem getOpen() {
        return Open;
    }

    public JMenuItem getRemove() {
        return Remove;
    }

    public JMenuItem getSave() {
        return Save;
    }

    public JMenuItem getSaveAs() {
        return SaveAs;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public JFileChooser getjFileChooser() {
        return jFileChooser;
    }

}
