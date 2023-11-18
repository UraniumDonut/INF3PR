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
 * Generiert Zufallszahlen und gibt diese an die Subscriber weiter
 * @author basti
 */
public class ZahlenGenerator implements Runnable{
    private SubmissionPublisher<Integer> publisher;
    private boolean active;
    private Thread trd;
    
    /**
     * Konstrukter erzeugt einen neuen SubmissionPublisher und deaktiviert die Würfelfunktion
     */
    public ZahlenGenerator(){
        publisher = new SubmissionPublisher<>(); 
        active = false;
    }
    /**
     * Gibt eine Zufallszahl zwischen 1 und 6 zurück
     * @return Zufallszahl
     */
    @Override
    public void run() {
        int i = 1;
        RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
        while(active){
            i = 1 + g.nextInt(6);
            publisher.submit(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        trd = null;
    }
    /**
     * Startet den Thread und somit die Würfelfunktion
     */
    public void Start(){
        active = true;
        if(trd == null){
           trd = new Thread(this); 
           trd.start();
        }
    }
    /**
     * Stoppt den Thread und somit die Würfelfunktion
     */
    public void Stop(){
        active = false;
    }
    /**
     * Fügt einen Subscriber hinzu
     * @param subscriber Subscriber
     */
    public void addSubscriber(Subscriber<Integer> subscriber){
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
    } 
}
