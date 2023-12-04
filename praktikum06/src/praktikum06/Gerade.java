/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JComponent;

/**
 *
 * @author basti
 */
public class Gerade extends JComponent implements Runnable{
  private static final float DICKE = 5f; //Stiftdicke
  private BasicStroke stift;

  private Line2D.Float gerade;
  private int winkel = 0;
  private static final float LAENGE = 50;

  private ExecutorService eService;
  private Future task;
  private int zeit;
  private Thread thd;

  public Gerade(int zeit){
    gerade = new Line2D.Float();
    stift = new BasicStroke(DICKE);
    eService = Executors.newSingleThreadExecutor();
    task = null;
    thd = null;
    this.zeit = zeit;
  }

  public void start(){
    if (task == null){
      task = eService.submit(this);
     
    }
    if (thd == null){
      thd = new Thread(this);
      thd.start();
    }
  }
  
  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g); // Das braucht man vor allem bei alten Systemen
		Graphics2D g2 = (Graphics2D)g; // Cast von Graphics auf Graphics2d
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    float x = this.getWidth()/2;
    float y = this.getHeight()/2;
    
    float endX = (float) Math.cos(Math.toRadians(winkel))*LAENGE +x;
    float endY = (float) Math.sin(Math.toRadians(winkel))*LAENGE +y;
    
    gerade.setLine(x,y,endX,endY);
    
    g2.setStroke(stift);
		g2.setPaint(Color.RED);
		g2.draw(gerade);
  }

  @Override
  public void run(){
    while(true){
      winkel++;
      if(winkel >= 360){
        winkel = 0;
      }
      this.repaint();
      try{
        Thread.sleep(10 * zeit);
      }
      catch(Exception ex){
        //lg.severe(ex.toString());
    }
    }
    
  } 
}

