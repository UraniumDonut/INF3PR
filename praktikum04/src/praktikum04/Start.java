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
 * Startklasse
 * @author Leon
 */
public class Start {

    /**
     * Konstruktor, erstellt ein neues Fenster, Model, Controller und Adapter
     */
    public Start() {
        Fenster frm = new Fenster();
        ZahlenGenerator model = new ZahlenGenerator();
        Controller ctrl = new Controller(model, frm);
        Adapter adapter = new Adapter(frm, model);
        model.addSubscriber(adapter);
        ctrl.registerEvents();
        frm.setVisible(true);
    }

    /**
     * Main-Methode, setzt das LookAndFeel und erstellt ein neues Start-Objekt
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
