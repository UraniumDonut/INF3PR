/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import praktikum08.ChatView;
import praktikum08.Transmitter;

/**
 *
 * @author basti
 */
public class ReceiveAdapter implements Subscriber<String>{
    ChatView view;
    Transmitter model;
    Flow.Subscription sub;
    
    public ReceiveAdapter(ChatView view, Transmitter model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        sub = subscription;
        sub.request(1);
    }

    @Override
    public void onNext(String item) {
        view.getChatTextArea().append(item + System.lineSeparator());
        sub.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
