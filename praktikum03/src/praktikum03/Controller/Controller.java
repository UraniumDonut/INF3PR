/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum03.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import praktikum03.Controller.Commands.CommandInvoker;
import praktikum03.Controller.Commands.ExitCommand;
import praktikum03.Controller.Commands.OpenCommand;
import praktikum03.Controller.Commands.SaveCommand;
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
    view.getSave().addActionListener(this);
    view.getSaveAs().addActionListener(this);
    view.getExit().addActionListener(this);
    view.getjButton1().addActionListener(this);
    view.getjButton2().addActionListener(this);
    view.getjButton3().addActionListener(this);
    view.getjButton4().addActionListener(this);
    view.getAddEntry().addActionListener(this);
    view.getRemoveEntry().addActionListener(this);
  }
  
  public void setupTable(){
    DefaultTableModel tablemodel = (DefaultTableModel)view.getjTable1().getModel();
    int rows = model.getRowCount();
    int col = model.getColumnCount();
    for(int i = 0; i<col; i++){
      System.out.println(model.getColumnName(i));
      tablemodel.addColumn(model.getColumnName(i));
    }
    
    Vector row = new Vector();
    row.add("hey");
    row.add("hi");
    tablemodel.addRow(row);
  }
  
  public void registerCommands(){
    invoker.addCommand(view.getOpen(), new OpenCommand(view,model));
    invoker.addCommand(view.getExit(), new ExitCommand(view,model));
    invoker.addCommand(view.getSaveAs(), new SaveCommand(view, model));
  }
  @Override
  public void actionPerformed(ActionEvent evt)
  {
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }
}
