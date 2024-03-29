/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum06;


import java.awt.Container;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.OverlayLayout;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import praktikum06.logger.GluecksLogger;

/**
 *
 * @author basti
 */
public class Start {
    private static final Logger lg = GluecksLogger.getLogger();
    private Gerade[] ger;
    
    private Start(){
      JFrame frm = new JFrame();
      frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      Container kiste = frm.getContentPane();
      kiste.setLayout(new OverlayLayout(kiste));
      ger = new Gerade[3];
      int i = 1;
      for (Gerade g : ger){
        g = new Gerade(i++);
        g.setOpaque(false);
        g.start();
        kiste.add(g);
      }
      frm.setSize(300,300);
      frm.setVisible(true);
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
