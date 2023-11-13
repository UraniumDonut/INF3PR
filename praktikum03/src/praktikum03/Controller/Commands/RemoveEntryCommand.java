/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Controller.Commands;

import praktikum03.Model.AdressverwaltungModel;
import praktikum03.Model.RowData;
import praktikum03.View.Fenster;

/**
 *
 * @author Leon
 */
public class RemoveEntryCommand implements CommandInterface
{

  Fenster view;
  AdressverwaltungModel model;

  public RemoveEntryCommand(Fenster frm, AdressverwaltungModel m)
  {
    view = frm;
    model = m;
  }

  @Override
  public void execute()
  {
    model.table2model(view);
    int row = view.getjTable1().getSelectedRow();
    if (model.getRowCount() > 0 && row != -1)
    {
      model.putRowUndoStack(row);
      model.deleteRowData(row);
      model.updateTable(view);
    }
  }

  @Override
  public void undo()
  {
    RowData rowData = new RowData();
    rowData = model.getRowUndoStack();
    model.insertRowData(rowData.idx, rowData.str);
    model.updateTable(view);
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
