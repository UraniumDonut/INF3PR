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
 *
 * @author Leon
 */
public final class ZahlenGenerator implements Runnable
{

  private final SubmissionPublisher<Integer> publisher;
  private final Thread trd;
  private boolean active;

  public ZahlenGenerator()
  {
    publisher = new SubmissionPublisher<>();
    trd = new Thread(this);
    active = false;
  }

  @Override
  public void run()
  {
    int i;
    RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
    while (true)
    {
      i = 1 + g.nextInt(6);
      publisher.submit(i);
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException ex)
      {
        Logger.getLogger(ZahlenGenerator.class.getName()).log(Level.SEVERE, null, ex);
      }
      while (active == false)
            synchronized (trd)
      {
        try
        {
          trd.wait();
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
        active = true;
        synchronized (trd) {
            trd.notify();
        }
    }

    /**
     * Stoppt den ZahlenGenerator
     */
    public void stop() {
        active = false;
    }
    /**
     * Fügt einen Subscriber hinzu
     * @param subscriber
     */
    public void initZahlenGenerator(Flow.Subscriber<Integer> subscriber) {
        publisher.subscribe(subscriber);
        System.out.println("Subscriber hinzugefügt");
        trd.start();
    }
}
