/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import praktikum08.ChatView;
import praktikum08.Transmitter;

/**
 *
 * @author basti
 */
public class CommandConnect implements ActionListener{
    ChatView view;
    Transmitter model;
    Flow.Subscription sub;
    
    public CommandConnect(ChatView view, Transmitter model){
        this.view = view;
        this.model = model;
    }
    
    public void registerEvents(){
        view.getBtnConnect().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ip = view.getTfIP().getText();
        model.connect(ip);
    }
    
    
}
