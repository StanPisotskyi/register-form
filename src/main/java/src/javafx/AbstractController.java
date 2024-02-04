package src.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

abstract class AbstractController {
    protected final short width = 700;
    protected final short height = 400;

    protected void showWindow(Button button, String path) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(path));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene newScene = new Scene(fxmlLoader.getRoot(), this.width, this.height);
        Stage currentStage = (Stage)button.getScene().getWindow();
        currentStage.setScene(newScene);
    }
}
