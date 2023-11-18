/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum04.Adapter;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import praktikum04.Model.ZahlenGenerator;
import praktikum04.View.Fenster;

/**
 * Adapter zwischen Model und View
 * @author basti
 */
public class Adapter implements Subscriber<Integer>{
    private Fenster view;
    private ZahlenGenerator model;
    private Subscription subscription;
    
    /**
     * Konstrukter erzeugt einen neuen Adapter
     * @param view View
     * @param model Model
     */
    public Adapter(Fenster view, ZahlenGenerator model){
        this.view = view;
        this.model = model;
    }

    /**
     * Registriert den Adapter als Subscriber
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * Setzt die Zahl in der View
     * @param item Zahl
     */
    @Override
    public void onNext(Integer item) {
        System.out.println("Wert erhalten");
        view.getLblZahl().setText(item.toString());
        subscription.request(1);
    }

    /**
     * Gibt eine Fehlermeldung aus
     * @param throwable Fehler
     */
    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Gibt eine Fehlermeldung aus
     * @param throwable Fehler
     */
    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
