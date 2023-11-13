/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum03.Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import praktikum03.View.Fenster;

/**
 * Model für die Adressverwaltung
 *
 * @author le, basti, Leon
 */
public class AdressverwaltungModel extends AbstractTableModel {

    private ArrayList<ArrayList<String>> daten;
    private ArrayList<String> adressEintraegeDaten;
    private ArrayList<String> adressEintraegeNamen;
    private UndoDataHolder undoData;

    public AdressverwaltungModel() {
        adressEintraegeDaten = new ArrayList<>();
        adressEintraegeNamen = new ArrayList<>();
        daten = new ArrayList<>();
        adressEintraegeNamen.add("Name");
        adressEintraegeDaten.add("Lehner");
        adressEintraegeNamen.add("Telefon");
        adressEintraegeDaten.add("122345");
        daten.add(adressEintraegeDaten);
        undoData = new UndoDataHolder();
    }

    /**
     * Gibt die Anzahl der Zeilen zurück
     *
     * @return Anzahl der Zeilen
     */
    @Override
    public int getRowCount() {
        return daten.size();
    }

    /**
     * Gibt die Anzahl der Spalten zurück
     *
     * @return Anzahl der Spalten
     */
    @Override
    public int getColumnCount() {
        return adressEintraegeDaten.size();
    }

    /**
     * Gibt den Wert an der Stelle (row, col) zurück
     *
     * @param row Zeile
     * @param col Spalte
     * @return Wert an der Stelle (row, col)
     */
    @Override
    public Object getValueAt(int row, int col) {
        return daten.get(row).get(col);
    }

    /**
     * Setzt den Wert an der Stelle (row, col) auf value
     *
     * @param value neuer Wert
     * @param row Zeile
     * @param col Spalte
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        daten.get(row).set(col, (String) value);
    }

    /**
     * Gibt zurück, ob die Zelle an der Stelle (row, col) editierbar ist
     *
     * @param row Zeile
     * @param col Spalte
     * @return true, wenn die Zelle editierbar ist, sonst false
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    /**
     * Gibt den Namen der Spalte col zurück
     *
     * @param col Spalte
     * @return Name der Spalte col
     */
    @Override
    public String getColumnName(int col) {
        return adressEintraegeNamen.get(col);
    }

    /**
     * Gibt die Daten der Zeile row zurück
     *
     * @param row Zeile
     * @return Daten der Zeile row
     */
    public ArrayList<String> getRowData(int row) {
        return daten.get(row);
    }

    /**
     * Fügt eine neue Zeile mit den Daten rowData an der Stelle row ein
     *
     * @param row Zeile
     * @param rowData Daten der neuen Zeile
     */
    public void insertRowData(int row, ArrayList<String> rowData) {
        daten.add(row, rowData);
        this.fireTableDataChanged();
    }

    /**
     * Löscht die Zeile row
     *
     * @param row Zeile
     */
    public void deleteRowData(int row) {
        ArrayList<String> rowData = daten.remove(row);
        this.fireTableDataChanged();
    }

    /**
     * Fügt eine neue Zeile mit den Column Namen am Ende ein
     */
    public void leerenAdressEintragAnhaengen() {
        adressEintraegeDaten = new ArrayList<>();
        adressEintraegeNamen.forEach(s -> adressEintraegeDaten.add(s));
        daten.add(adressEintraegeDaten);
        this.fireTableDataChanged();
    }

    /**
     * Fügt eine neue Spalte mit dem Namen name an der Stelle col ein
     *
     * @param col Spalte
     * @param name Name der Spalte
     */
    public void spalteHinzufuegen(int col, String name) {
        adressEintraegeNamen.add(name);
        daten.forEach(s -> s.add(col, " "));
        this.fireTableStructureChanged();
    }

    /**
     * Löscht die Spalte col
     *
     * @param col Spalte
     */
    public void spalteLoeschen(int col) {
        adressEintraegeNamen.remove(col);
        daten.forEach(s -> s.remove(col));
        this.fireTableStructureChanged();
    }

    /**
     * Speichert die Daten in der Datei datei
     *
     * @param datei Datei, in der die Daten gespeichert werden sollen
     * @throws FileNotFoundException Wenn die Datei nicht gefunden wurde
     * @throws IOException Wenn ein Fehler beim Schreiben auftritt
     */
    public void datenSpeichern(File datei) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(datei);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(daten);
        oos.writeObject(adressEintraegeNamen);
        oos.flush();
        oos.close();
    }

    /**
     * Liest die Daten aus der Datei datei
     *
     * @param datei Datei, aus der die Daten gelesen werden sollen
     * @throws FileNotFoundException Wenn die Datei nicht gefunden wurde
     * @throws IOException Wenn ein Fehler beim Lesen auftritt
     * @throws ClassNotFoundException Wenn die Klasse nicht gefunden wurde
     */
    public void datenLesen(File datei) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(datei);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        daten = (ArrayList<ArrayList<String>>) ois.readObject();
        adressEintraegeNamen = (ArrayList<String>) ois.readObject();
        adressEintraegeDaten = daten.get(daten.size() - 1);
        ois.close();
        this.fireTableDataChanged();
    }

    /**
     * Kopiert die Daten aus der Tabelle in das Model
     *
     * @param view View, aus der die Daten gelesen werden sollen
     */
    public void table2model(Fenster view) {
        JTable table = view.getjTable1();
        int rows = this.getRowCount();
        int col = this.getColumnCount();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                this.setValueAt(table.getValueAt(i, j), i, j);
            }
        }
    }

    /**
     * Kopiert die Daten aus dem Model in die Tabelle
     *
     * @param view View, in die die Daten geschrieben werden sollen
     */
    public void updateTable(Fenster view) {
        DefaultTableModel tablemodel = (DefaultTableModel) view.getjTable1().getModel();
        tablemodel.setRowCount(0);
        tablemodel.setColumnCount(0);
        int rows = this.getRowCount();
        int col = this.getColumnCount();
        for (int i = 0; i < col; i++) {
            tablemodel.addColumn(this.getColumnName(i));
        }
        for (int i = 0; i < rows; i++) {
            var row = new Vector();
            for (int j = 0; j < col; j++) {
                row.add(this.getValueAt(i, j));
            }
            tablemodel.addRow(row);
        }
    }

    /**
     * Gibt die neuste Row aus dem UndoStack zurück
     *
     * @return neuste Row aus dem UndoStack
     */
    public RowData getRowUndoStack() {
        return undoData.getRowEntry();
    }

    /**
     * Fügt eine Row in den UndoStack ein
     *
     * @param row Die einzufügende Zeile
     */
    public void putRowUndoStack(int row) {
        RowData rd = new RowData(row, new ArrayList(this.getRowData(row)));
        undoData.putRowEntry(rd);
    }

    /**
     * Löscht den UndoStack
     */
    public void clearUndoStack() {
        undoData.clearUndoDataHolder();
    }
}

/**
 * Klasse für die Undo/Redo Funktion, speichert die Daten einer Zeile
 *
 * @author le
 */
class UndoDataHolder {

    private ArrayDeque<ArrayList<String>> stackFuerGeloeschteDatensaetze;
    private ArrayDeque<Integer> stackForIndex;

    public UndoDataHolder() {
        stackFuerGeloeschteDatensaetze = new ArrayDeque<>();
        stackForIndex = new ArrayDeque<>();
    }

    /**
     * Speichert die Daten einer Zeile
     *
     * @param rd Daten einer Zeile
     */
    public void putRowEntry(RowData rd) {
        stackFuerGeloeschteDatensaetze.push(rd.str);
        stackForIndex.push(rd.idx);
    }

    /**
     * Gibt die Daten einer Zeile zurück
     *
     * @return Daten einer Zeile
     */
    public RowData getRowEntry() {
        RowData rd = new RowData();
        rd.str = stackFuerGeloeschteDatensaetze.pop();
        rd.idx = stackForIndex.pop();
        return rd;
    }

    /**
     * Löscht den UndoStack
     */
    public void clearUndoDataHolder() {
        stackFuerGeloeschteDatensaetze.clear();
    }
}
