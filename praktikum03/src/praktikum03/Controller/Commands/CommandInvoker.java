/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author basti
 */
public class CommandInvoker {
    private HashMap<Object, CommandInterface> commands;
  /** Stack für das Undo von Kommandos */
  private Stack<CommandInterface> undoStack;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack<>();
  }
  
  /**
   * Fügt Kommando zur Kommando-Datenbank (= HashMap) hinzu
   * @param key Quelle des Events
   * @param value zugehöriges Kommando-Objekt
   */
  public void addCommand(Object key, CommandInterface value)
  {
    commands.put(key, value);
  }
  
  public void executeCommand(Object key)
  {
    CommandInterface command = commands.get(key);
    command.execute();
    if (command.isUndoable())
    {
      undoStack.push(command);
    }
  }
  
  public void undoCommand()
  {
    if (!undoStack.isEmpty())
    {
      undoStack.pop().undo();
    }
  }
}
