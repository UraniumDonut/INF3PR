/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum07;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JComponent;

/**
 *
 * @author basti
 */
public class GraphicViewer extends JComponent implements Printable
{
  private GraphicModel model;
  private Line2D.Float line;
  public GraphicViewer(){
  }
  public void initView(GraphicModel model){
    this.model = model;
    this.line = new Line2D.Float();
  }
  
  @Override
  public void paintComponent(Graphics g){
    if (model == null){
      return;
    }
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    model.getLines().forEach(n -> {
      line = n;
      g2.draw(line);
    });
    
  }
  
  public void doPrint()
  {
    HashPrintRequestAttributeSet printSet = new HashPrintRequestAttributeSet();
    printSet.add(DialogTypeSelection.NATIVE);
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(this);

    if (pj.printDialog(printSet))
    {
      try
      {
        pj.print(printSet);
      }
      catch (PrinterException ex)
      {
        Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  @Override
  public int print(Graphics gp, PageFormat pf, int pageIndex) throws PrinterException
  {
    Graphics2D gp2 = (Graphics2D) gp;
    if (pageIndex == 0)
    {
      gp2.translate(pf.getImageableX(), pf.getImageableX());
      gp2.scale(pf.getImageableHeight(), pf.getImageableWidth());
      super.print(gp2);
      return Printable.PAGE_EXISTS;
    }
    else
    {
      return Printable.NO_SUCH_PAGE;
    }
  }
}
