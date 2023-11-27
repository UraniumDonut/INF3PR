/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum06;


import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum06.logger.GluecksLogger;

/**
 *
 * @author basti
 */
public class Start {
    private static final Logger lg = GluecksLogger.getLogger();
    
    private Start(){
        Winkelgeber wg = new Winkelgeber();
        wg.startThread();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }// TODO code application logic here
    
}
