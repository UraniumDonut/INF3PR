/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum08.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;
import praktikum08.Logger.GluecksLogger;
import praktikum08.model.Model;
import praktikum08.view.ChatView;

/**
 *
 * @author basti
 */
public class CommandConnect implements ActionListener, Runnable
{

  private static final Logger lg = GluecksLogger.getLogger();

  ChatView view;
  Model model;

  public CommandConnect(ChatView view, Model model)
  {
    this.view = view;
    this.model = model;
  }

  public void registerEvents()
  {
    view.getBtnConnect().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    Thread trd = new Thread(this);
    trd.start();
  }

  @Override
  public void run()
  {
    String ip = view.getTfIP().getText();
    boolean isServer = view.getServerCheckbox().isSelected();
    try
    {
      model.connect(isServer, ip);
    }
    catch (IOException ex)
    {
      lg.severe(ex.getLocalizedMessage());
    }
  }

}
