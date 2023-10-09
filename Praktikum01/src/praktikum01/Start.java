/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum01;

/**
 *
 * @author Leon
 */
public class Start 
{
  public Start()
  {
    Fenster frm = new Fenster("mein tolles erstes Fenster");
    frm.registerEvents();
    frm.setVisible(true);
  }
  

  public static void main(String[] args) 
  {
    new Start();
  }

}
