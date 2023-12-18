/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import praktikum08.view.ChatView;
import praktikum08.model.Transmitter;

/**
 *
 * @author basti
 */
public class CommandSend implements ActionListener{
    private ChatView view;
    private Transmitter model;
    
    public CommandSend(ChatView view, Transmitter model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = view.getInputField().getText();
        view.getChatTextArea().append(msg + System.lineSeparator());
        view.getInputField().setText("");
        model.send(msg);
    }
    
    public void registerEvents(){
        view.getSendButton().addActionListener(this);
        view.getInputField().addActionListener(this);
    }
}
