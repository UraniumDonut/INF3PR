/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum05.Model;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;

/**
 *Zahlengenerator erzeugt zufällige Zahlen zwischen 1 und 6 für eine zufällige Zeit 
 * @author Leon
 */
public final class ZahlenGenerator implements Runnable
{

  private final SubmissionPublisher<WuerfelWert> publisher;
  private Thread trd;
  private int active;
  private final int wuerfel;
  private final Object LOCK;
  RandomGenerator g;
  
  public ZahlenGenerator(int wuerfel)
  {
    this.wuerfel = wuerfel;
    publisher = new SubmissionPublisher<>();
    LOCK = new Object();
    active = 0;
    g = RandomGenerator.of("L64X128MixRandom");
  }
/**
 * Erzeugt in einem eigenen Thread eine zufällige Anzahl an zufälligen Zahlen zwischen 1 und 6.
 * Diese werden dann an alle subscriber submitted.
 */
  @Override
  public void run()
  {
    int i;
    RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
    while (true)
    {
      i = 1;//1 + g.nextInt(6);
      WuerfelWert wert = new WuerfelWert(wuerfel,i);
      publisher.submit(wert);
      active--;
      System.out.println("Zahlengenerator " + wuerfel + ": neuer Wert: " + wert.getWert());
      try
      {
        Thread.sleep(20);
      }
      catch (InterruptedException ex)
      {
        Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
      }
      while (active <= 0)
      synchronized (LOCK)
      {
        try
        {
          LOCK.wait();
        }
        catch (InterruptedException ex)
        {
          Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
          System.exit(-10);
        }
      }
    }
  }
  
      /**
     * Startet den ZahlenGenerator
     */
    public void start() {
        active = g.nextInt(20, 50);
        synchronized (LOCK) {
            LOCK.notify();
        }
        System.out.println("Zahlengenerator " + wuerfel + " start()");
    }

    /**
     * Fügt einen Subscriber hinzu
     * @param subscriber
     */
    public void initZahlenGenerator(Flow.Subscriber<WuerfelWert> subscriber) {
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
        if (trd == null){
            trd = new Thread(this);
        }
        System.out.println("Zahlengenerator " + wuerfel + " start new Thread");
        trd.start();
    }
/**
 * Gibt zurück, ob der Zahlengenerator noch aktiv ist
 * @return 
 */
    public int getActive() {
        return active;
    }
}    