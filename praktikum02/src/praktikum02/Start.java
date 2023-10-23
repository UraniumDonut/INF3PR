/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum02;

import praktikum02.View.Fenster;
import java.util.Locale;
import praktikum02.Controller.CMController;
import praktikum02.Controller.ZollController;
import praktikum02.Model.Model;

/**
 *
 * @author Leon
 */
public class Start 
{
  public Start()
  {
    Fenster frm = new Fenster();
    Model model = new Model();
    CMController cmController = new CMController(frm,model);
    ZollController zollController = new ZollController(frm, model);
    cmController.registerEvents();
    zollController.registerEvents();
    frm.setVisible(true);
    //frm.registerEvents();
  }

  public static void main(String[] args) 
  {
    Locale locale = Locale.GERMAN;
    
    
    new Start();
  }

}
