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
 * Die Klasse enthält das Kommando für das Speichern der der Daten in einem 
 * File, dass über den JFileChooser selektiert wird. Erbt von Command Interface.
 */
public class SaveAsCommand implements CommandInterface
{

  private Fenster view;
  private AdressverwaltungModel model;
  private Preferences pref;
  
/**
 * 
 * @param v Ansichts Element der MVC-Struktur
 * @param m Modell Element der MVC-Struktur
 * @Konstruktor für SaveAsCommand
 */
  public SaveAsCommand(Fenster v, AdressverwaltungModel m)
  {
    view = v;
    model = m;
    pref = Preferences.userNodeForPackage(this.getClass());
  }

  /**
  *Führt den Aufruf der des SaveAs aus. Zunächst wird ein Dateiauswahlfenster geöffnet, dann werden die Daten in dieses abgespeichert.
  * 
  */
  @Override
  public void execute()
  {
    model.table2model(view);
    view.getjFileChooser().setCurrentDirectory(new File(pref.get("DIRECTORY", ".")));
    int ret = view.getjFileChooser().showSaveDialog(view);
    pref.put("DIRECTORY", view.getjFileChooser().getCurrentDirectory().getPath());
    if (ret == ERROR_OPTION)
    {
      //throw new Exception("Open failed.");
    }
    else if (ret == APPROVE_OPTION)
    {
      File file = view.getjFileChooser().getSelectedFile();
      if (!file.exists())
      {
        System.out.println("Existiert nicht!");
        try
        {
            file.createNewFile();
        }
        catch (IOException ex)
        {
          Logger.getLogger(SaveAsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      try
      {
        model.datenSpeichern(file);
        pref.put("CURRENT_FILE", file.toString());
        view.getFileName().setText(file.getPath());
        model.clearUndoStack();
      }
      catch (IOException ex)
      {
        Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }

  /**
   * Überschreibt die Funktion undo des CommandInterfaces, wirft aber nur eine Exception, da hier kein undo vorgesehen ist.
   */
  @Override
  public void undo()
  {
    throw new UnsupportedOperationException("Not supported for the last command."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  /**
   * Abfrage, ob für das Kommando ein Undo vorgesehen ist
   * @return Boolean, der beschreibt, ob ein Undo vorgesehen ist.
   */
  @Override
  public boolean isUndoable()
  {
    return false;
  }
//    jFileChooser.showOpenDialog();
}
