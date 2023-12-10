/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum07.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Shape implements Serializable
{
  ArrayList<Point> points;
  public Shape(Point beginning)
  {
    points = new ArrayList<>();
    points.add(beginning);
  }
  
  public void addPoint(Point p){
    points.add(p);
  }
  public List<Point> getPoints(){
    return Collections.unmodifiableList(points);
  }
}
