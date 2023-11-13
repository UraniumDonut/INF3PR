/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import java.util.prefs.Preferences;
import javax.swing.JTable;
import praktikum03.Model.AdressverwaltungModel;
import praktikum03.Model.RowData;
import praktikum03.View.Fenster;

/**
 * Speichert die Änderungen in der Tabelle bei Drücken der Enter-Taste
 * @author Leon
 */
public class finishEditCommand implements CommandInterface
{

  Fenster view;
  AdressverwaltungModel model;
  Preferences pref;

  public finishEditCommand(Fenster frm, AdressverwaltungModel m)
  {
    view = frm;
    model = m;
  }

  @Override
  public void execute()
  {
    JTable table = view.getjTable1();
        int rows = model.getRowCount();
        int col = model.getColumnCount();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (!table.getValueAt(i, j).equals(model.getValueAt(i, j))){
                    model.putRowUndoStack(i);
                }
            }
        }
    model.table2model(view);
    model.updateTable(view);
  }

  @Override
  public void undo()
  {
    model.table2model(view);
    RowData rd = new RowData();
    rd = model.getRowUndoStack();
    model.deleteRowData(rd.idx);
    model.insertRowData(rd.idx, rd.str);
    model.updateTable(view);              
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
