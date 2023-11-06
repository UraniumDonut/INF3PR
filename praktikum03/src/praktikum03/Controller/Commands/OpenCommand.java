/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

/**
 *
 * @author basti
 */
public class OpenCommand implements CommandInterface{

    @Override
    public void execute() {                                       
        //jFileChooser1.showOpenDialog(Open);
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Command not redoable."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
    
}
