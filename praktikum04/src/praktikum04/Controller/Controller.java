/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum04.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import praktikum04.Model.ZahlenGenerator;
import praktikum04.View.Fenster;

/**
 * Controller für das Programm
 * @author basti
 */
public class Controller implements ActionListener{
    ZahlenGenerator model;
    Fenster view;
    
    /**
     * Erstellt einen neuen Controller
     * @param model Model des Programms
     * @param view View des Programms
     */
    public Controller(ZahlenGenerator model, Fenster view){
        this.view = view;
        this.model = model;
    }
    /**
     * Startet oder stoppt den ZahlenGenerator je nachdem welcher Button gedrückt wurde
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Component key = (Component)evt.getSource();    
        if (key == view.getBtnStart()){
            model.Start();
        }
        else if(key == view.getBtnStop()){
            model.Stop();
        }
    }
    /**
     * Registriert die Events
     */
    public void registerEvents(){
        view.getBtnStart().addActionListener(this);
        view.getBtnStop().addActionListener(this);
    }
}
