package praktikum05.Adapter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import javax.swing.JOptionPane;
import praktikum05.Model.Bandit;
import praktikum05.Model.WuerfelWert;
import praktikum05.View.View;

/**
 * Adapter zwischen Model und View
 *
 * @author basti
 */
public class Adapter implements Subscriber<WuerfelWert>
{

  private View view;
  private Bandit model;
  private Subscription subscription;

  /**
   * Erstellt einen neuen Adapter
   *
   * @param view View des Programms
   * @param model Model des Programms
   */
  public Adapter(View view, Bandit model)
  {
    this.view = view;
    this.model = model;
  }

  /**
   * Speichert die Subscription und fordert eine Zahl an
   */
  @Override
  public void onSubscribe(Flow.Subscription subscription)
  {
    this.subscription = subscription;
    subscription.request(1);
  }

  /**
   * Gibt die Zahl an die View weiter und fordert eine neue Zahl an
   */
  @Override
  public void onNext(WuerfelWert item)
  {
    System.out.println("Wuerfel " + item.getWuerfel() + "Wert erhalten: " + item.getWert());
    switch (item.getWuerfel())
    {
      case 0:
        view.getLblZahl0().setText(item.getWert() + "");
        break;
      case 1:
        view.getLblZahl1().setText(item.getWert() + "");
        break;
      case 2:
        view.getLblZahl2().setText(item.getWert() + "");
        break;

    }
    subscription.request(1);
    if (model.getFinished()){
        if (view.getLblZahl0().getText().equals(view.getLblZahl1().getText()) 
                && view.getLblZahl0().getText().equals(view.getLblZahl2().getText())
                && view.getLblZahl1().getText().equals(view.getLblZahl2().getText())){
            JOptionPane.showInputDialog(view, """
                                              3 Gleiche, sie haben gewonnen!!!
                                              Gib hier deine IBAN ein um den Gewinn zu erhalten:""");
        }
    }
  }

  /**
   * Gibt eine Fehlermeldung aus
   *
   * @param throwable Fehler
   */
  @Override
  public void onError(Throwable throwable)
  {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  /**
   * Gibt eine Fehlermeldung aus
   *
   * @param throwable Fehler
   */
  @Override
  public void onComplete()
  {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
