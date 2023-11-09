/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.ERROR_OPTION;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 */
public class SaveCommand implements CommandInterface{
    Fenster view;
    AdressverwaltungModel model;
    
    public SaveCommand(Fenster v, AdressverwaltungModel m){
        view = v;
        model = m;
    }

    @Override
    public void execute() {
        int ret = view.getjFileChooser().showSaveDialog(view);
        if (ret == ERROR_OPTION){
            //throw new Exception("Open failed.");
        }
        else if (ret == APPROVE_OPTION){
            File file = view.getjFileChooser().getSelectedFile();
            try {
                model.datenSpeichern(file);
            } catch (IOException ex) {
                Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
//    jFileChooser.showOpenDialog();
}
