/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import java.util.prefs.Preferences;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.View.Fenster;

/**
 * Fügt einen neuen Eintrag in die Tabelle ein
 * @author Leon
 */
public class AddEntryCommand implements CommandInterface
{

  Fenster view;
  AdressverwaltungModel model;
  Preferences pref;

  public AddEntryCommand(Fenster frm, AdressverwaltungModel m)
  {
    view = frm;
    model = m;
  }
  
  @Override
  public void execute()
  {
    //int row = view.getjTable1().getSelectedRow();
    model.table2model(view);
    model.leerenAdressEintragAnhaengen();   //Das macht ganz komischen scheiss
    model.updateTable(view);
  }

  @Override
  public void undo()
  {
      model.deleteRowData(model.getRowCount()-1);
      model.updateTable(view);
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
