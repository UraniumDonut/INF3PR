/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum02.Model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class Model 
{
  static final Double UMRECHNUNGSFAKTOR = 2.54;
  double cm;
  double zoll;
  public Model()
  {
  
  }
  
  public double getZoll(){
    return zoll;
  }
  
  public void setCM(double cm){
    this.cm = cm;
  }
  public double getCM(){
    return cm;
  }
  public void setZoll(double zoll){
    this.zoll = zoll;
  }
  public void calculateCM(){
    cm = zoll * UMRECHNUNGSFAKTOR;
  }
  public void calculateZoll(){
    zoll = cm * UMRECHNUNGSFAKTOR;
  }
  
}
