/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum03.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import praktikum03.Controller.Commands.AddEntryCommand;
import praktikum03.Controller.Commands.CommandInvoker;
import praktikum03.Controller.Commands.ExitCommand;
import praktikum03.Controller.Commands.OpenCommand;
import praktikum03.Controller.Commands.RemoveEntryCommand;
import praktikum03.Controller.Commands.SaveAsCommand;
import praktikum03.Controller.Commands.SaveCommand;
import praktikum03.Controller.Commands.finishEditCommand;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author Leon
 */
public class Controller implements ActionListener, KeyListener, CellEditorListener
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
    view.getjTable1().addKeyListener(this);
    //view.getjTable1().getCellEditor().addCellEditorListener(this);
  }
  
  public void startApp(){
    model.updateTable(view);
    
  }
  
  public void registerCommands(){
    invoker.addCommand(view.getOpen(), new OpenCommand(view,model));
    invoker.addCommand(view.getExit(), new ExitCommand(view,model));
    invoker.addCommand(view.getSaveAs(), new SaveAsCommand(view, model));
    invoker.addCommand(view.getAddEntry(), new AddEntryCommand(view,model));
    invoker.addCommand(view.getjButton3(), new AddEntryCommand(view,model));
    invoker.addCommand(view.getRemoveEntry(), new RemoveEntryCommand(view,model));
    invoker.addCommand(view.getjButton4(), new RemoveEntryCommand(view,model));
    invoker.addCommand(view.getSave(), new SaveCommand(view, model));
    invoker.addCommand(view.getjButton1(), new SaveCommand(view, model));
    invoker.addCommand(view.getjTable1(), new finishEditCommand(view,model));
    invoker.addCommand(view.getjTable1(), new finishEditCommand(view,model));
    //invoker.addCommand(view.getjTable1().getCellEditor(), new finishEditCommand(view,model));
  }
  @Override
  public void actionPerformed(ActionEvent evt)
  {
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }

  @Override
  public void keyTyped(KeyEvent e)
  {
  }

  @Override
  public void keyPressed(KeyEvent evt)
  {
    System.out.println("key released!");
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }

  @Override
  public void keyReleased(KeyEvent evt)
  {
    System.out.println("key released!");
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }

  @Override
  public void editingStopped(ChangeEvent evt)
  {
    System.out.println("Editing stopped!");
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }

  @Override
  public void editingCanceled(ChangeEvent e)
  {
  }

}
