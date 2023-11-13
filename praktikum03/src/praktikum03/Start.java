/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum03;

//mport java.lang.ModuleLayer.Controller;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum03.Controller.Controller;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author Sebastian und Leon
 */
public class Start {

    /**
     * Creates new Start Object with MVC
     */
    public Start() {
        Fenster frm = new Fenster();
        AdressverwaltungModel model = new AdressverwaltungModel();
        Controller controller = new Controller(frm, model);
        controller.startApp();
        controller.registerEvents();
        controller.registerCommands();
        frm.setVisible(true);
    }

    /**
     * Main Methode, welche bei Programmstart aufgerufen wird
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }

}
