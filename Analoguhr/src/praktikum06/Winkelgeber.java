/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum06;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author basti
 */
public class Winkelgeber implements Runnable{
    private Gerade g;
    private Thread trd;
    
    public Winkelgeber(){
        g = new Gerade();
    }
    @Override
    public void run() {
        
    }
    public void startThread(){
        trd = new Thread(this);
        trd.start();
    }
}
