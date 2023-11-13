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
import static javax.swing.JFileChooser.FILES_ONLY;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 *
 * @author basti
 * @param view
 */
public class OpenCommand implements CommandInterface
{

  private Fenster view;
  private AdressverwaltungModel model;
  private Preferences pref;

  public OpenCommand(Fenster frm, AdressverwaltungModel m)
  {
    view = frm;
    model = m;
    pref = Preferences.userNodeForPackage(this.getClass());
  }

  @Override
  public void execute()
  {
    model.table2model(view);
    view.getjFileChooser().setCurrentDirectory(new File(pref.get("DIRECTORY", ".")));
    view.getjFileChooser().setFileSelectionMode(FILES_ONLY);
    int ret = view.getjFileChooser().showOpenDialog(view);
    pref.put("DIRECTORY", view.getjFileChooser().getCurrentDirectory().getPath());
    if (ret == ERROR_OPTION)
    {
      //throw new Exception("Open failed.");
    }
    else if (ret == APPROVE_OPTION)
    {
      File file = view.getjFileChooser().getSelectedFile();
      try
      {
        model.datenLesen(file);
        pref.put("CURRENT_FILE", file.getPath());
        view.getFileName().setText(file.getPath());
        model.clearUndoStack();
      }
      catch (IOException ex)
      {
        Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (ClassNotFoundException ex)
      {
        Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    model.updateTable(view);
  }

  @Override
  public void undo()
  {
    throw new UnsupportedOperationException("Command not redoable."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public boolean isUndoable()
  {
    return false;
  }

}
