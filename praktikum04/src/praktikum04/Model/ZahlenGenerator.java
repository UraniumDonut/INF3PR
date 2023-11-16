/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum04.Model;

import static java.lang.Thread.sleep;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;

/**
 *
 * @author basti
 */
public class ZahlenGenerator implements Runnable{
    private SubmissionPublisher<Integer> publisher;
    private Thread trd;
    
    public ZahlenGenerator(){
        publisher = new SubmissionPublisher<>(); 
        trd = new Thread(this); 
        trd.start();
        this.Stop();
    }
    @Override
    public void run() {
        int i = 1;
        RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
        while(true){
            i = 1 + g.nextInt(6);
            publisher.submit(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Start(){
        synchronized (this) {
            trd.notify();
        }
    }
    public void Stop(){
        try {
            trd.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-10);
        }
    }
    public void addSubscriber(Subscriber<Integer> subscriber){
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
    } 
}
