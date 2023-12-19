/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Logger;
import praktikum08.Logger.GluecksLogger;

/**
 *
 * @author basti
 */
public class Transmitter implements Runnable
{

  private static final Logger lg = GluecksLogger.getLogger();

  private static final int PORT = 8080;
  private ObjectInputStream isr;
  private ObjectOutputStream osw;
  private final SubmissionPublisher<Object> pub;

  private Thread trd;

  public Transmitter()
  {
    pub = new SubmissionPublisher<>();
  }

  public void connect(boolean isServer, String IP) throws IOException
  {
    Socket s = null;
    if (isServer)
    {
      ServerSocket sSocket = new ServerSocket(PORT);
      s = sSocket.accept(); //Das Blockiert und muss im Thread sein bei GUI Applikationen
    }
    else
    {
      s = new Socket(IP, PORT); //Das Blockiert und muss im Thread sein bei GUI Applikationen
    }
    lg.info("connected");
    OutputStream os = s.getOutputStream();
    InputStream ins = s.getInputStream();

    BufferedOutputStream bos = new BufferedOutputStream(os);
    BufferedInputStream bis = new BufferedInputStream(ins);

    osw = new ObjectOutputStream(bos);
    osw.flush();
    isr = new ObjectInputStream(bis);

    //out = new PrintWriter(osw); //ist cooler, weil wir hier die println und printf funktionen haben
    if (trd == null)
    {
      trd = new Thread(this);
      trd.start();
    }
  }

  @Override
  public void run()
  {
    while (true)
    {
      try
      {
        Object daten = isr.readObject();
        if (daten instanceof Shape)
        {
          pub.submit(daten);
        }
        Thread.sleep(100);
      }
      catch (IOException | ClassNotFoundException | InterruptedException ex)
      {
        lg.severe(ex.getLocalizedMessage());
      }
    }
  }

  public void addSubscriber(Subscriber<Object> subscriber)
  {
    pub.subscribe(subscriber);
  }

  public void send(Object obj)
  {
    try
    {
      osw.writeObject(obj);
      osw.flush();
    }
    catch (IOException ex)
    {
      lg.severe(ex.getLocalizedMessage());
    }
  }
}
