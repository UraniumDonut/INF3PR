/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum05;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum05.Adapter.Adapter;
import praktikum05.Controller.Controller;
import praktikum05.Model.Bandit;
import praktikum05.Model.ZahlenGenerator;
import praktikum05.View.View;

/**
 *
 * @author Leon
 */
public class Start 
{
  /**
     * Erstellt ein neues Fenster, Model und Controller und startet das Programm
     */
    public Start() {
        View frm = new View();
        Bandit model = new Bandit();
        Controller ctrl = new Controller(model, frm);
        Adapter adapter = new Adapter(frm, model);
        ctrl.registerEvents();
        model.addSubscriber(adapter);
        frm.setVisible(true);
        System.out.println("Init done");
    }

  /**
     * Startet das Programm
     * @param args
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
