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
 *
 * @author Leon
 */
public class finishEditCommand implements CommandInterface {

    Fenster view;
    AdressverwaltungModel model;
    Preferences pref;

    public finishEditCommand(Fenster frm, AdressverwaltungModel m) {
        view = frm;
        model = m;
    }

    /**
     * Speichert die Änderungen in der Tabelle bei Drücken der Enter-Taste
     */
    @Override
    public void execute() {
        /*model.putRowUndoStack(view.getjTable1().getSelectedRow());*/
    }

    @Override
    public void undo() {
        /*RowData rd = model.getRowUndoStack();
        model.deleteRowData(rd.idx);
        model.insertRowData(rd.idx, rd.str);*/
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
