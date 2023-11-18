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
 * Controller-Klasse, die die Events der Buttons verarbeitet und an das Model weitergibt
 * @author basti
 */
public class Controller implements ActionListener{
    ZahlenGenerator model;
    Fenster view;
    
    /**
     * Konstruktor
     * @param model Model
     * @param view View
     */
    public Controller(ZahlenGenerator model, Fenster view){
        this.view = view;
        this.model = model;
    }
    /**
     * Verarbeitet die Events der Buttons
     * @param evt Event
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
     * Registriert die Events der Buttons
     */
    public void registerEvents(){
        view.getBtnStart().addActionListener(this);
        view.getBtnStop().addActionListener(this);
    }
}
