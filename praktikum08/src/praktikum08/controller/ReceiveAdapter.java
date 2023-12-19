/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.logging.Logger;
import praktikum08.Logger.GluecksLogger;
import praktikum08.model.GraphicModel;
import praktikum08.model.Shape;
import praktikum08.view.ChatView;
import praktikum08.model.Transmitter;

/**
 *
 * @author basti
 */
public class ReceiveAdapter implements Subscriber<Object>{
    private static Logger lg = GluecksLogger.getLogger();
    ChatView view;
    Transmitter transModel;
    GraphicModel graphicModel;
    Flow.Subscription sub;
    
    public ReceiveAdapter(ChatView view, Transmitter transModel, GraphicModel graphicModel){
        this.view = view;
        this.transModel = transModel;
        this.graphicModel = graphicModel;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        sub = subscription;
        sub.request(1);
    }

    @Override
    public void onNext(Object item) {
        graphicModel.addShape((Shape)item);
        lg.info("Shape received");
        view.getGraphicViewer().repaint();
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
