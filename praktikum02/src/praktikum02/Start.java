/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum02;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Leon
 */
public class Start 
{
  public Start()
  {
    Fenster frm = new Fenster();
    frm.setVisible(true);
    frm.registerEvents();
  }

  public static void main(String[] args) 
  {
    Locale locale = Locale.GERMAN;
    
    
    new Start();
  }

}
