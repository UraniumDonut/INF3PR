/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 */
public class OpenCommand implements CommandInterface{
    Fenster view;
    AdressverwaltungModel model;
    public OpenCommand(Fenster frm, AdressverwaltungModel m){
        view = frm;
        model = m;
    }
    @Override
    public void execute() {    
        //view.getjFileChooser().showOpenDialog(Open);
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
