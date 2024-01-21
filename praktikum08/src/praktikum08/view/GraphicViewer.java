/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.List;
import javax.swing.JComponent;
import praktikum08.model.Model;

/**
 *
 * @author basti
 */
public class GraphicViewer extends JComponent
{

  private Model model;
  private Line2D.Float line;
  private Point lastPoint = null;
  public GraphicViewer()
  {
  }

  public void initView(Model model)
  {
    this.model = model;
    this.line = new Line2D.Float();
  }
  
  public void drawLine(Point p){
    Graphics2D g2 = (Graphics2D)this.getGraphics();
    if(lastPoint != null){
      g2.draw(new Line2D.Float(lastPoint, p));
    }
    else{
      g2.draw(new Line2D.Float(p,p));
    }
    lastPoint = p;
  }
  
  public void resetPoint(){
    this.lastPoint = null;
  }

  @Override
  public void paintComponent(Graphics g)
  {
    if (model == null)
    {
      return;
    }
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    model.getShapes().forEach(s ->
    {
      List<Point> points = s.getPoints();
      Point pointBefore = null;
      for (Point p:points)
      {
        if (pointBefore == null)
        {
          //do nothing
          pointBefore = p;
        }
        else
        {
          line = new Line2D.Float(pointBefore, p);
          g2.draw(line);
          pointBefore = p;
        }
      }
    });
  }
}
