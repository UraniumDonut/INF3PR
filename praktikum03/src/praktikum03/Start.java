/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum03;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public void Start() {
        Fenster frm = new Fenster();
        AdressverwaltungModel model = new AdressverwaltungModel();
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }

}
