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
import praktikum08.model.Model;
import praktikum08.model.Shape;
import praktikum08.view.ChatView;

/**
 *
 * @author basti
 */
public class CommandSend implements MouseMotionListener, MouseListener{
    private final ChatView view;
    private final Model model;
    
    public CommandSend(ChatView view, Model model){
        this.view = view;
        this.model = model;
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
    model.addPoint(p);
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
    view.getGraphicViewer().repaint();
    model.createShape(p);
    view.getGraphicViewer().resetPoint();
    view.getGraphicViewer().drawLine(p);
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    List<Shape> shapes = model.getShapes();
    Shape last = shapes.get(shapes.size() - 1);
    model.send(last);
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
