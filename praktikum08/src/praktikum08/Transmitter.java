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

/**
 *
 * @author basti
 */
public class Transmitter
{

  private static final int PORT = 35400;

  public Transmitter()
  {
  }

  public void initTransmitter(boolean isServer, String IP) throws IOException
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

    BufferedReader in = new BufferedReader(isr);
    //BufferedWriter out = new BufferedWriter(osw); 
    PrintWriter out = new PrintWriter(osw); //ist cooler, weil wir hier die println und printf funktionen haben
  }

}
