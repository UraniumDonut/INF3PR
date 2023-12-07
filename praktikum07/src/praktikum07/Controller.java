/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.prefs.Preferences;

/**
 *
 * @author basti
 */
public class Controller implements MouseMotionListener, MouseListener, ActionListener
{

  GraphicViewer view;
  GraphicModel model;
  Window window;
  Preferences pref;
  public Controller(GraphicViewer view, GraphicModel model, Window window)
  {
    this.view = view;
    this.model = model;
    this.window = window;
    pref = Preferences.userNodeForPackage(this.getClass());
  }

  public void registerEvents()
  {
    view.addMouseListener(this);
    view.addMouseMotionListener(this);
    window.getOpenButton().addActionListener(this);
    window.getSaveButton().addActionListener(this);
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    model.addPoint(e.getPoint());
    view.repaint();
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
    model.addShape(e.getPoint());
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == window.getOpenButton()){
      //model.savePoints();
    }
  }
}
