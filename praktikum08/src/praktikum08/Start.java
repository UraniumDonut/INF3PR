/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package praktikum08;

import praktikum08.view.ChatView;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import praktikum08.controller.CommandConnect;
import praktikum08.controller.CommandSend;
import praktikum08.controller.ReceiveAdapter;
import praktikum08.model.Model;

/**
 *
 * @author Leon
 */
public class Start 
{
  public Start()
  {
    Model model = new Model();
    ChatView view = new ChatView();
    view.getGraphicViewer().initView(model);
    ReceiveAdapter ra = new ReceiveAdapter(view, model);
    CommandConnect cc = new CommandConnect(view, model);
    CommandSend cs = new CommandSend(view, model);
    cc.registerEvents();
    cs.registerEvents();
    model.addSubscriber(ra);
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
