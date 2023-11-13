/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package praktikum03.Controller.Commands;

/**
 * Repräsentiert das Command Interface, welches von den Commands genutzt wird.
 * @author basti
 */
public interface CommandInterface {
  public void execute();
  public void undo();
  public boolean isUndoable();
}
