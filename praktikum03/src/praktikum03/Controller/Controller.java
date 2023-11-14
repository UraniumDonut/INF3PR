/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum03.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
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
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;


/**
 * Controller für die Adressverwaltung
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

  /**
   * Registriert die Events der View
   */

  public void registerEvents(){
    view.getOpen().addActionListener(this);
    view.getSave().addActionListener(this);
    view.getSaveAs().addActionListener(this);
    view.getExit().addActionListener(this);
    view.gettoolbarSave().addActionListener(this);
    view.gettoolbarDelete().addActionListener(this);
    view.gettoolbarAdd().addActionListener(this);
    view.gettoolbarRemove().addActionListener(this);
    view.getAddEntry().addActionListener(this);
    view.getRemoveEntry().addActionListener(this);
    view.getPopUpAdd().addActionListener(this);
    view.getPopUpRemove().addActionListener(this);
    view.gettoolbarUndo().addActionListener(this::undo);
  }
  
  /**
   * Wird beim Start der Anwendung genutzt, um den Inhalt der Tabelle zu aktualisieren
   */
  public void startApp(){
    model.updateTable(view);
  }

  /**
   * Registriert die Commands der View im CommandInvoker
   */
  public void registerCommands(){
    invoker.addCommand(view.getOpen(), new OpenCommand(view,model));
    invoker.addCommand(view.getExit(), new ExitCommand(view,model));
    invoker.addCommand(view.getSaveAs(), new SaveAsCommand(view, model));
    AddEntryCommand addcommand = new AddEntryCommand(view,model);
    invoker.addCommand(view.getAddEntry(), addcommand);
    invoker.addCommand(view.gettoolbarAdd(), addcommand);
    invoker.addCommand(view.getPopUpAdd(), addcommand);
    RemoveEntryCommand removecommand = new RemoveEntryCommand(view,model);
    invoker.addCommand(view.getRemoveEntry(), removecommand);
    invoker.addCommand(view.gettoolbarRemove(), removecommand);
    invoker.addCommand(view.getPopUpRemove(), removecommand);
    invoker.addCommand(view.getSave(), new SaveCommand(view, model));
    invoker.addCommand(view.gettoolbarSave(), new SaveCommand(view, model));
  }
  /**
   * Wird aufgerufen, wenn ein Knopf oder Menüpunkt gedrückt wurde
   * @param evt Event, das ausgelöst wurde
   */
  @Override
  public void actionPerformed(ActionEvent evt)
  {
    Component key = (Component)evt.getSource();
    invoker.executeCommand(key);
  }

  public void undo(ActionEvent evt){
    invoker.undoCommand();     
  }
}

