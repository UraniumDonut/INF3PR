/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum04;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum04.Adapter.Adapter;
import praktikum04.Controller.Controller;
import praktikum04.Model.ZahlenGenerator;
import praktikum04.View.Fenster;

/**
 *
 * @author Leon
 */
public class Start {

    public Start() {
        Fenster frm = new Fenster();
        ZahlenGenerator model = new ZahlenGenerator();
        Controller ctrl = new Controller(model, frm);
        Adapter adapter = new Adapter(frm, model);
        ctrl.registerEvents();
        model.initZahlenGenerator(adapter);
        frm.setVisible(true);
        System.out.println("Init done");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }

}
