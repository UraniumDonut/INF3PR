/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum07.controller;

import java.awt.Point;
import praktikum07.model.GraphicModel;
import praktikum07.view.Window;
import praktikum07.view.GraphicViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.ERROR_OPTION;
import static javax.swing.JFileChooser.FILES_ONLY;

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
    window.getOpenButton().addActionListener(this::open);
    window.getPrintButton().addActionListener(this::print);
    window.getSaveButton().addActionListener(this::save);
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    Point p = e.getPoint();
    model.addPoint(p);
    view.drawLine(p);
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
    model.addShape(p);
    view.resetPoint();
    view.drawLine(p);
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
  
  public void print(ActionEvent evt){
      view.doPrint();
      System.out.println("Datei gedruckt.");
  }
  
  public void save(ActionEvent evt)
  {
    JFileChooser jfChooser = new JFileChooser();
    jfChooser.setCurrentDirectory(new File(pref.get("DIRECTORY", ".")));
    int ret = jfChooser.showSaveDialog(view);
    pref.put("DIRECTORY", jfChooser.getCurrentDirectory().getPath());
    if (ret == ERROR_OPTION)
    {
      //throw new Exception("Open failed.");
    }
    else if (ret == APPROVE_OPTION)
    {
        try {
            File file = jfChooser.getSelectedFile();
            if (!file.exists())
            {
                System.out.println("Existiert nicht!");
                try
                {
                    file.createNewFile();
                    System.out.println(file.toString());
                }
                catch (IOException ex)
                {
                    Logger.getLogger("SaveFile").log(Level.SEVERE, null, ex);
                }
            }
            model.saveShapes(file.toString());
            pref.put("CURRENT_FILE", file.toString());
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }

  public void open(ActionEvent evt)
  {
      JFileChooser jfChooser = new JFileChooser();
    jfChooser.setCurrentDirectory(new File(pref.get("DIRECTORY", ".")));
    jfChooser.setFileSelectionMode(FILES_ONLY);
    int ret = jfChooser.showOpenDialog(view);
    pref.put("DIRECTORY", jfChooser.getCurrentDirectory().getPath());
    if (ret == ERROR_OPTION)
    {
      //throw new Exception("Open failed.");
    }
    else if (ret == APPROVE_OPTION)
    {
      File file = jfChooser.getSelectedFile();
      try {
          model.readShapes(file.toString());
          view.repaint();
      } catch (Exception ex) {
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
      }
      pref.put("CURRENT_FILE", file.getPath());
    }
  }
}

