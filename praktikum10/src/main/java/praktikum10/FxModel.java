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
public class FxModel implements Runnable{
    private LocalTime t;
    private Thread trd;
    private StringProperty str;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    
    public void initModel(){
        if(trd == null){
            str = new SimpleStringProperty();
            str.set("00:00");
            trd = new Thread(this);
            trd.start();
        }
    }
    public StringProperty getProperty(){
        return str;
    }
    
//    public String getTime(){
//        t = LocalTime.now();
//        return t.toString();
//    }

    @Override
    public void run() {
        while(true){
            t = LocalTime.now();
            str.set(t.format(dtf));
            try {
                trd.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
