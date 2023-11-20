/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum05.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import praktikum05.Model.Bandit;
import praktikum05.Model.ZahlenGenerator;
import praktikum05.View.View;

/**
 * Controller für das Programm
 * @author basti
 */
public class Controller implements ActionListener{
    Bandit model;
    View view;
    
    /**
     * Erstellt einen neuen Controller
     * @param model Model des Programms
     * @param view View des Programms
     */
    public Controller(Bandit model, View view){
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
            model.start();
        }
        else if(key == view.getBtnStop()){
            model.stop();
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