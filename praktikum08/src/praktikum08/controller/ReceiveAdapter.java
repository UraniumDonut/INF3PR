/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.logging.Logger;
import praktikum08.Logger.GluecksLogger;
import praktikum08.model.Model;
import praktikum08.model.Shape;
import praktikum08.view.ChatView;

/**
 *
 * @author basti
 */
public class ReceiveAdapter implements Subscriber<Object>{
    private static final Logger lg = GluecksLogger.getLogger();
    ChatView view;
    Model model;
    Flow.Subscription sub;
    
    public ReceiveAdapter(ChatView view, Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        sub = subscription;
        sub.request(1);
    }

    @Override
    public void onNext(Object item) {
        model.addShape((Shape)item);
        lg.info("Shape received");
        view.repaint();
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
