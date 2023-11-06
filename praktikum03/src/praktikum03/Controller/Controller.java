/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum03.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import praktikum03.Controller.Commands.CommandInvoker;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author Leon
 */
public class Controller implements ActionListener
{
  private Fenster view;
  private AdressverwaltungModel model;
  private CommandInvoker invoker;
  
  public Controller(Fenster view, AdressverwaltungModel model)
  {
    this.view = view;
    this.model = model;
    this.invoker = new CommandInvoker();
  }

  
  public void registerEvents(){
    view.getOpen().addActionListener(this);
  }
  
  public void registerCommands(){
    
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    
  }
}
