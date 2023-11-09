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
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.ERROR_OPTION;
import static javax.swing.JFileChooser.FILES_AND_DIRECTORIES;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 */
public class SaveAsCommand implements CommandInterface{
    private Fenster view;
    private AdressverwaltungModel model;
    private Preferences pref;
    
    public SaveAsCommand(Fenster v, AdressverwaltungModel m){
        view = v;
        model = m;
        pref = Preferences.userNodeForPackage(this.getClass());
    }

    @Override
    public void execute() {
        view.getjFileChooser().setCurrentDirectory(new File(pref.get("DIRECTORY", ".")));
        int ret = view.getjFileChooser().showSaveDialog(view);
        pref.put("DIRECTORY", view.getjFileChooser().getCurrentDirectory().getPath());
        if (ret == ERROR_OPTION){
            //throw new Exception("Open failed.");
        }
        else if (ret == APPROVE_OPTION){
            File file = view.getjFileChooser().getSelectedFile();
            if(!file.exists()){
                System.out.println("Existiert nicht!");
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(SaveAsCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                model.datenSpeichern(file);
                pref.put("CURRENT_FILE", file.toString());
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
//    jFileChooser.showOpenDialog();
}
