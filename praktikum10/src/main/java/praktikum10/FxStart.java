package praktikum10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class FxStart extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
      FXMLLoader fxmlLoader = new FXMLLoader();
      fxmlLoader.setLocation(this.getClass().getResource("FxView.fxml"));
      Parent root = fxmlLoader.load();
      FxController controller = (FxController) fxmlLoader.getController();
      FxModel model = new FxModel();
      controller.setModel(model);
      
      controller.registerBindings();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}