/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

import java.time.LocalTime;

/**
 *
 * @author basti
 */
public class FxModel {
    private LocalTime t;
    
    public String getTime(){
        t = LocalTime.now();
        return t.toString();
    }
}
