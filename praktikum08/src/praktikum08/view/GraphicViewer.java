/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JComponent;
import praktikum08.Start;
import praktikum08.model.GraphicModel;

/**
 *
 * @author basti
 */
public class GraphicViewer extends JComponent
{

  private GraphicModel model;
  private Line2D.Float line;
  private Point lastPoint = null;
  public GraphicViewer()
  {
  }

  public void initView(GraphicModel model)
  {
    this.model = model;
    this.line = new Line2D.Float();
  }
  
  public void drawLine(Point p){
    Graphics2D g2 = (Graphics2D)this.getGraphics();
    if(lastPoint != null){
      g2.draw(new Line2D.Float(lastPoint, p));
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
      Point pointNow;
      for (int i = 0; i < points.size(); i++)
      {
        if (i == 0)
        {
          //do nothing
          pointBefore = points.get(i);
        }
        else
        {
          pointNow = points.get(i);
          line = new Line2D.Float(pointBefore, pointNow);
          g2.draw(line);
          pointBefore = pointNow;
        }
      }
    });
  }
}
