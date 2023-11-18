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
 * generiert Zahlen und gibt diese an die Subscriber weiter
 * @author basti
 */
public class ZahlenGenerator implements Runnable{
    private SubmissionPublisher<Integer> publisher;
    private Thread trd;
    private boolean active;
    
    /**
     * Erstellt einen neuen SubmissionPublisher und startet den Thread
     */
    public ZahlenGenerator(){
        publisher = new SubmissionPublisher<>(); 
        active = false;
        trd = new Thread(this); 
        trd.start();
    }
    /**
     * Generiert eine Zufallszahl zwischen 1 und 6 und gibt diese an die Subscriber weiter
     */
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
    
    /**
     * Startet den ZahlenGenerator
     */
    public void Start(){
        active = true;
    }
    
    /**
     * Stoppt den ZahlenGenerator
     */
    public void Stop(){
        active = false;
    }
    
    /**
     * Fügt einen Subscriber hinzu
     * @param subscriber Der Subscriber, der hinzugefügt werden soll
     */
    public void addSubscriber(Subscriber<Integer> subscriber){
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
    } 
}
