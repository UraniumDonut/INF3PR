/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum07;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author basti
 */
public class GraphicModel {
    private ArrayList<Line2D.Float> lines;
    
    public void addLine(Point2D start, Point2D end){
        lines.add(new Line2D.Float((Point2D)start,(Point2D)end));
    }
    
    public List<Line2D> getLines(){
      return Collections.unmodifiableList(lines);
    }
    public void savePoints(String filename) throws Exception{
        //Preference
        FileOutputStream fos = new FileOutputStream(filename);
        // Puffer für Performance
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //Serialisierung
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(lines);
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
            lines = liste;
        }
        
        ois.close();
    }
}
