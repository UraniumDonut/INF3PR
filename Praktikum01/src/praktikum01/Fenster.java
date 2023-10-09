/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum01;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class Fenster extends JFrame implements MouseListener, WindowListener
{
  public Fenster(String titel)
  {
    this.setTitle(titel); //aus Parent class
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(1000, 800);
  }
  
   public void registerEvents(){
    this.addMouseListener(this); 
    this.addWindowListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
  }

  @Override
  public void mouseReleased(MouseEvent evt){
    float rot = (float)Math.random();
    float gruen = (float)Math.random();
    float blau = (float)Math.random();
    this.getContentPane().setBackground(new Color(rot,gruen,blau));
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
  public void windowOpened(WindowEvent e)
  {
  }

  @Override
  public void windowClosing(WindowEvent evt)
  {
    int ans = JOptionPane.showConfirmDialog(this,"Willst du das Fenster wirklich schließen?", "Obacht!", JOptionPane.YES_NO_OPTION);
    if(ans == JOptionPane.YES_OPTION)
    {
      System.exit(0);
    }
  }

  @Override
  public void windowClosed(WindowEvent e)
  {
  }

  @Override
  public void windowIconified(WindowEvent e)
  {
  }

  @Override
  public void windowDeiconified(WindowEvent e)
  {
  }

  @Override
  public void windowActivated(WindowEvent e)
  {
  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
  }
 
  

  
}


