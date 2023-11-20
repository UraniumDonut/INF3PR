/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum05.Model;

/**
 *
 * @author Leon
 */
public class WuerfelWert 
{
  int wuerfel;
  int wert;
  public WuerfelWert(int wuerfel, int wert)
  {
    this.wuerfel = wuerfel;
    this.wert = wert;
  }
  
  public int getWert(){return wert;}
  public int getWuerfel(){return wuerfel;}
}
