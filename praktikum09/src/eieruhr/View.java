/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package eieruhr;

import javax.swing.JLabel;

/**
 *
 * @author basti
 */
public class View extends javax.swing.JPanel {

    /**
     * Creates new form View
     */
    public View() {
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

        lblNumber = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        lblNumber.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumber.setText("0");
        lblNumber.setMaximumSize(new java.awt.Dimension(1000, 1000));
        lblNumber.setMinimumSize(new java.awt.Dimension(50, 50));
        lblNumber.setPreferredSize(new java.awt.Dimension(100, 100));
        add(lblNumber, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getjLabel1() {
        return lblNumber;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNumber;
    // End of variables declaration//GEN-END:variables
}
