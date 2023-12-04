/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum07;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author basti
 */
public class GraphicModel {
    private ArrayList<Point> points;
   
    
    public void savePoints(String filename) throws Exception{
        //Preference
        FileOutputStream fos = new FileOutputStream(filename);
        // Puffer für Performance
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //Serialisierung
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(points);
        oos.flush(); //Puffer!
        oos.close();
    }
    
    public void readPoints(String filename) throws Exception{
        //Preference
        FileInputStream fis = new FileInputStream(filename);
        // Puffer für Performance
        BufferedInputStream bis = new BufferedInputStream(fis);
        //Deserialisierung
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        Object daten = ois.readObject();
        
        if (daten instanceof ArrayList liste){
            punkte = liste;
        }
        
        ois.close();
    }
}
