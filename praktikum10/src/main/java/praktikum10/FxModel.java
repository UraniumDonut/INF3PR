/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author basti
 */
public class FxModel{
    private LocalTime t;
    private StringProperty str;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    
    public void initModel(){
            str = new SimpleStringProperty();
            t = LocalTime.now();
            str.set(t.format(dtf));
    }
    public StringProperty getProperty(){
        return str;
    }
    
//    public String getTime(){
//        t = LocalTime.now();
//        return t.toString();
//    }

}
