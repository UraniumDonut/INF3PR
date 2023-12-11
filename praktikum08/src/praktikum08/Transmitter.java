/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basti
 */
public class Transmitter  implements Runnable
{

  private static final int PORT = 35400;
  private BufferedReader in;
  private PrintWriter out;
  private SubmissionPublisher<String> pub;

  public Transmitter()
  {
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

    InputStream ins = s.getInputStream();
    OutputStream os = s.getOutputStream();

    InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
    OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); //Das sind jetzt Strings

    in = new BufferedReader(isr);
    //BufferedWriter out = new BufferedWriter(osw); 
    out = new PrintWriter(osw); //ist cooler, weil wir hier die println und printf funktionen haben
  }

    @Override
    public void run() {
      try {
          String str = in.readLine();
          if(str != null){
              pub.submit(str);
          }
      } catch (IOException ex) {
          Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void addSubscriber(Subscriber<String> subscriber){
        pub.subscribe(subscriber);
    }
}
