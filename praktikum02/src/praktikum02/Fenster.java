/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praktikum02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Leon
 */
public class Fenster extends JFrame implements ActionListener
{
  static final Double UMRECHNUNGSFAKTOR = 2.54;
  private JButton btnLinks;
	private JButton btnRechts;
  private JLabel lblZoll;
  private JLabel lblCM;
  private JTextField tfZoll;
  private JTextField tfCM;
	
	public Fenster(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
		btnLinks = new JButton("<");
		btnRechts = new JButton(">");
    lblZoll = new JLabel("Zoll");
    lblCM = new JLabel("cm");
    tfZoll = new JTextField(10);
    tfZoll.setHorizontalAlignment(JTextField.RIGHT);
    tfCM = new JTextField(10);
    tfCM.setHorizontalAlignment(JTextField.RIGHT);
    
		Container hauptKiste = this.getContentPane();
		hauptKiste.setLayout(new BorderLayout()); 
    
    Container gridKiste = new Container();
    gridKiste.setLayout(new GridLayout(2,3));
    
    gridKiste.add(lblZoll);
		gridKiste.add(btnRechts);
    gridKiste.add(lblCM);
    gridKiste.add(tfZoll);
		gridKiste.add(btnLinks);
    gridKiste.add(tfCM);

    hauptKiste.add(gridKiste, BorderLayout.NORTH);
    this.pack();
    
	}
  
  public void registerEvents()
	{
		btnLinks.addActionListener(this);
		btnRechts.addActionListener(this);
    tfZoll.addActionListener(this::zollZuCM);
    tfCM.addActionListener(this::cmZuZoll);
	}
  
  @Override
  public void actionPerformed(ActionEvent evt)
	{
		Object src = evt.getSource();
		if (src == btnRechts){
      zollZuCM();
		}
		else if (src == btnLinks){
      cmZuZoll();
		}
	}
  
  public void zollZuCM(ActionEvent... evt){
    double zollWert = getNumber(0);
    String cmText = "";
    System.out.println("ZollWert = " + zollWert);
    cmText = String.format("%.2f", (zollWert*UMRECHNUNGSFAKTOR));
    tfCM.setText(cmText);
  }
  
  public void cmZuZoll(ActionEvent... evt){
    double cmWert = getNumber(1);
    String zollText = "";
    System.out.println("CMWert = " + cmWert);
    zollText = String.format("%.2f", (cmWert/UMRECHNUNGSFAKTOR));
    tfZoll.setText(zollText);
  }
  
  public double getNumber(int which){  // 0 = Zoll, 1 = CM
    NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
    
    double zahlenWert = 0;
    try{
        if(which == 0){
          Number number = format.parse(tfZoll.getText());
          zahlenWert = number.doubleValue();
        }
        else if(which == 1){
          Number number = format.parse(tfCM.getText());
          zahlenWert = number.doubleValue();
        }
      }
    catch(Exception e){
        System.out.println("Bitte nur Zahl eintippen!");
        JOptionPane.showMessageDialog(this,"Bitte Zahl eintippen im Format 1.234,56");
    }
    return zahlenWert;
  }
  
}
