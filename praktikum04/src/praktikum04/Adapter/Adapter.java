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
 * Adapter-Klasse, die die Zahlen vom Model an die View weitergibt und anfordert
 * @author basti und leon
 */
public class Adapter implements Subscriber<Integer>{
    private Fenster view;
    private ZahlenGenerator model;
    private Subscription subscription;
    
    /**
     * Konstruktor
     * @param view View
     * @param model Model
     */
    public Adapter(Fenster view, ZahlenGenerator model){
        this.view = view;
        this.model = model;
    }

    /**
     * Speichert die Subscription und fordert eine Zahl an
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * Gibt die Zahlen an die View weiter
     * @param item
     */
    @Override
    public void onNext(Integer item) {
        System.out.println("Wert erhalten");
        view.getLblZahl().setText(item.toString());
        subscription.request(1);
    }

    /**
     * Erzeugt eine Fehlermeldung
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Erzeugt eine Fehlermeldung
     */
    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
