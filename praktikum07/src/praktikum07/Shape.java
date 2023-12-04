/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum07;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Shape 
{
  ArrayList<Point> points;
  public Shape(Point beginning)
  {
    points = new ArrayList<Point>();
    points.add(beginning);
  }
  
  void addPoint(Point p){
    points.add(p);
  }
  List<Point> getPoints(){
    return Collections.unmodifiableList(points);
  }
}
