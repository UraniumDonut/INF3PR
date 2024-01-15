package praktikum10;

import java.io.IOException;
import javafx.fxml.FXML;

public class FxController {

    @FXML
    private void switchToSecondary() throws IOException {
        FxStart.setRoot("secondary");
    }
}
