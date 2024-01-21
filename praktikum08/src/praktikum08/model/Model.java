/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.model;

import java.awt.Point;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;

/**
 *
 * @author basti
 */
public class Model {
    private Transmitter tra;
    private GraphicModel gm;
    
    public Model(){
        tra = new Transmitter();
        gm = new GraphicModel();
    }
    
    public void connect(boolean isServer, String ip) throws IOException{
        tra.connect(isServer, ip);
    }
    
    public void addShape(Shape shape){
        gm.addShape(shape);
    }
    
    public void addPoint(Point p){
        gm.addPoint(p);
    }
    
    public List<Shape> getShapes(){
        return gm.getShapes();
    }
    
    public void createShape(Point p){
        gm.createShape(p);
    }
    
    public void send(Shape shape){
        tra.send(shape);
    }
    
    public void addSubscriber(Subscriber sub){
        tra.addSubscriber(sub);
    }
}
