/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum08;

import praktikum08.view.ChatView;
import praktikum08.model.Transmitter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum08.controller.CommandConnect;
import praktikum08.controller.CommandSend;
import praktikum08.controller.ReceiveAdapter;
import praktikum08.model.GraphicModel;

/**
 *
 * @author Leon
 */
public class Start 
{
  public Start()
  {
    Transmitter trans_model = new Transmitter();
    GraphicModel graphic_model = new GraphicModel();
    ChatView view = new ChatView();
    ReceiveAdapter ra = new ReceiveAdapter(view, trans_model, graphic_model);
    CommandConnect cc = new CommandConnect(view, trans_model);
    CommandSend cs = new CommandSend(view, trans_model, graphic_model);
    cc.registerEvents();
    cs.registerEvents();
    trans_model.addSubscriber(ra);
    view.setVisible(true);
  }

  public static void main(String[] args) 
  {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.toString());
    }
    new Start();
  }

}
