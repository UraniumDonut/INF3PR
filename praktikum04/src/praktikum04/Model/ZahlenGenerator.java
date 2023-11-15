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
    private boolean active;
    
    public ZahlenGenerator(){
        publisher = new SubmissionPublisher<>(); 
        active = false;
        trd = new Thread(this); 
        trd.start();
    }
    @Override
    public void run() {
        int i;
        RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
        while(true){
            i = 1 + g.nextInt(6);
            if (active){
                publisher.submit(i);
            }
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Start(){
        active = true;
    }
    
    public void Stop(){
        active = false;
    }
    
    public void addSubscriber(Subscriber<Integer> subscriber){
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
    } 
}
