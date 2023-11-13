/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum03.Model;

import java.util.ArrayList;

/**
 *
 * @author basti
 */
public class RowData{
    public int idx;
    public ArrayList<String> str;
    public RowData(int i, ArrayList<String> s){
        idx = i;
        str = s;
    }
    public RowData(){}
}
