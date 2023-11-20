/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum05.Model;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

/**
 *
 * @author Leon
 */
public class Bandit implements Subscriber<WuerfelWert> {

    private Subscription subscription;
    SubmissionPublisher<WuerfelWert> publisher;
    ZahlenGenerator[] gen;

    public Bandit() {
        for (int i = 0; i < 3; i++) {
            gen = new ZahlenGenerator[3];
            gen[i] = new ZahlenGenerator(i);
        }
    }
    
    public void start(){
        for (int i = 0; i < 3; i++){
            gen[i].start();
        }
    }
    
    public void stop(){
        for (int i = 0; i < 3; i++){
            gen[i].stop();
        }
    }
    
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(WuerfelWert item) {
        subscription.request(1);
        publisher.submit(item);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addSubscriber(Subscriber sub) {
        publisher.subscribe(sub);
    }
}
