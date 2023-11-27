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

  private ExecutorService eService;
  private Future task;

  public Gerade(){
    gerade = new Line2D.Float();
    stift = new BasicStroke(DICKE);
    eService = Executors.newSingleThreadExecutor();
    task = null;
  }

  public void start(){
    if (task == null){
      task = eService.submit(this);
    }
  }
  
  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g); // Das braucht man vor allem bei alten Systemen
		Graphics2D g2 = (Graphics2D)g; // Cast von Graphics auf Graphics2d
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    float x = this.getWidth()/2;
    float y = this.getHeight()/2;
    
    gerade.setLine(x,y,x+10,y+10);
    
    g2.setStroke(stift);
		g2.setPaint(Color.RED);
		g2.draw(gerade);
  }

  @Override
  public void run(){

  } 
}

