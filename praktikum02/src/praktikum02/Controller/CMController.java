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
 * Rechnet Zoll in CM um
 * @author Leon
 */
public class CMController implements ActionListener
{
  Model model;
  Fenster gui;
  public CMController(Fenster gui, Model model)
  {
      this.gui = gui;
      this.model = model;
  }

  
public void registerEvents()
	{
		gui.getbtnRechts().addActionListener(this);
    gui.getTfZoll().addActionListener(this);
	}

  @Override
  public void actionPerformed(ActionEvent e)
  {
    model.setZoll(stringToDouble(gui.getTfZoll().getText()));
    model.calculateCM();
    gui.getTfCM().setText(String.format("%.2f",model.getCM()));
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

