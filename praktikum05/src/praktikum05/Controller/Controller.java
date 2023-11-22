/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum05.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import praktikum05.Model.Bandit;
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
     * Startet den einarmigen Banditen bei Drücken des Startknopfes
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
            model.start();
    }
    /**
     * Registriert die Events
     */
    public void registerEvents(){
        view.getBtnStart().addActionListener(this);
    }
}