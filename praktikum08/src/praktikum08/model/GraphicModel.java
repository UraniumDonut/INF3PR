/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.model;

import java.awt.Point;
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
    
}
