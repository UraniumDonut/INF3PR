/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum02.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import praktikum02.Model.Model;
import praktikum02.View.Fenster;

/**
 * Rechnet CM in Zoll um
 * @author Leon
 */
public class ZollController implements ActionListener
{
  Model model;
  Fenster gui;
  public ZollController(Fenster gui, Model model)
  {
      this.gui = gui;
      this.model = model;
  }

  
public void registerEvents()
	{
		gui.getbtnLinks().addActionListener(this);
    gui.getTfCM().addActionListener(this);
	}

  @Override
  public void actionPerformed(ActionEvent e)
  {
    model.setCM(stringToDouble(gui.getTfCM().getText()));
    model.calculateZoll();
    gui.getTfZoll().setText(String.format("%.2f",model.getZoll()));
  }
  
  public double stringToDouble(String text){
    NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
    Number number = 0;
    try
    {
      number = format.parse(text);
    }
    catch (ParseException ex)
    {
      System.out.println("Bitte nur Zahl eintippen!");
        JOptionPane.showMessageDialog(gui,"Bitte Zahl eintippen im Format 1.234,56");
    }
    
    return number.doubleValue();
   }
}
