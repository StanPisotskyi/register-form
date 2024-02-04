package src.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController extends AbstractController {

    @FXML
    private Button loginBtn;

    @FXML
    private TextField loginInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button registerBtn;

    @FXML
    public void initialize() {
        this.registerBtn.setOnAction(actionEvent -> {
            this.showWindow(this.registerBtn, "register.fxml");
        });
    }
}