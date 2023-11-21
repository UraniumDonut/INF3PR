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

    private Subscription[] subscription;
    SubmissionPublisher<WuerfelWert> publisher;
    ZahlenGenerator[] gen;
    int x;

    public Bandit() {
        gen = new ZahlenGenerator[3];
        for (int i = 0; i < 3; i++) {
            gen[i] = new ZahlenGenerator(i);
        }
        publisher = new SubmissionPublisher<>();
        subscription = new Subscription[3];
        x = 0;
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
        this.subscription[x++] = subscription;
        subscription.request(1);
        if (x > 3){
            System.exit(-5);
        }
    }

    @Override
    public void onNext(WuerfelWert item) {
        subscription[item.getWuerfel()].request(1);
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

    public void addSubscriber(Subscriber<WuerfelWert> sub) {
        publisher.subscribe(sub);
        for (int i = 0; i < 3; i++){
            gen[i].initZahlenGenerator(this);
        }
    }
}
