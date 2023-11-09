/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 */
public class SaveCommand implements CommandInterface{
    private AdressverwaltungModel model;
    private Fenster view;
    private Preferences pref;
    private SaveAsCommand saveAsCmd;
    
    public SaveCommand(Fenster v, AdressverwaltungModel m){
        model = m;
        view = v;
        pref = Preferences.userNodeForPackage(this.getClass());
    }
    @Override
    public void execute() {
        String s = pref.get("CURRENT_FILE", "");
        File file = new File(s);
        if(!file.exists()){
            saveAsCmd = new SaveAsCommand(view, model);
            saveAsCmd.execute();
        }
        else{
        try {
                model.datenSpeichern(file);
                view.getFileName().setText(file.getPath());
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
    
}
