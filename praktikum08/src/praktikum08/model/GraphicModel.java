/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.model;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    //private ArrayList<Point> points;
    private ArrayList<Shape> shapes;
    
    public GraphicModel(){
      this.shapes = new ArrayList<>();
    }
    
    public void addShape(Point point){
        shapes.add(new Shape(point));
    }
    
    public void addPoint(Point point){
        if(!shapes.isEmpty()){
          shapes.get(shapes.size() - 1).addPoint(point);
        }
    }
    
    public List<Shape> getShapes(){
      return Collections.unmodifiableList(shapes);
    }
    
    public void saveShapes(String filename) throws Exception{
        //Preference
        FileOutputStream fos = new FileOutputStream(filename);
        // Puffer für Performance
        BufferedOutputStream bos = new BufferedOutputStream(fos);
      try ( //Serialisierung
              ObjectOutputStream oos = new ObjectOutputStream(bos))
      {
        oos.writeObject(shapes);
        oos.flush(); //Puffer!
        oos.close();
      }
    }
    
    public void readShapes(String filename) throws Exception{
        //Preference
        FileInputStream fis = new FileInputStream(filename);
        // Puffer für Performance
        BufferedInputStream bis = new BufferedInputStream(fis);
      try ( //Deserialisierung
              ObjectInputStream ois = new ObjectInputStream(bis))
      {
        Object daten = ois.readObject();
        
        if (daten instanceof ArrayList list){
          shapes = list;
        }
      }
    }
}
