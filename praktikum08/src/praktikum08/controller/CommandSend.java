/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import praktikum08.model.GraphicModel;
import praktikum08.model.Shape;
import praktikum08.view.ChatView;
import praktikum08.model.Transmitter;

/**
 *
 * @author basti
 */
public class CommandSend implements MouseMotionListener, MouseListener{
    private ChatView view;
    private Transmitter trans_model;
    private GraphicModel graphic_model;
    
    public CommandSend(ChatView view, Transmitter trans_model, GraphicModel graphic_model){
        this.view = view;
        this.trans_model = trans_model;
        this.graphic_model = graphic_model;
    }
    
   public void registerEvents()
  {
    view.addMouseListener(this);
    view.addMouseMotionListener(this);
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    Point p = e.getPoint();
    graphic_model.addPoint(p);
    view.getGraphicViewer().drawLine(p);
    
  }

  @Override
  public void mouseMoved(MouseEvent e)
  {
  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    Point p = e.getPoint();
    view.repaint();
    graphic_model.createShape(p);
    view.getGraphicViewer().resetPoint();
    view.getGraphicViewer().drawLine(p);
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    List<Shape> shapes = graphic_model.getShapes();
    Shape last = shapes.get(shapes.size() - 1);
    trans_model.send(last);
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
  }
}
