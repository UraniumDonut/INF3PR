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

    @Override
    public void run() {
    try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }
    
}
