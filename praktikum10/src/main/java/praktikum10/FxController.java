package praktikum10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FxController implements Initializable{
  
  @FXML
	private TextField tfZugnummer;
  @FXML
	private TextField tfAbfahrtszeit;
  @FXML
	private TextField tfBahnhof;
  
  @FXML
  private Label lblZeit;
  @FXML
  private Label lblZugnummer;
  @FXML
  private Label lblAbfahrtszeit;
  @FXML
  private Label lblBahnhof;
          
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
  }
  
  public void registerBindings(){
    lblZugnummer.textProperty().bind(tfZugnummer.textProperty());
    lblAbfahrtszeit.textProperty().bind(tfAbfahrtszeit.textProperty());
    lblBahnhof.textProperty().bind(tfBahnhof.textProperty());
  }
  
}
