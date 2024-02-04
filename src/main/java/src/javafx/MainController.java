package src.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

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
        this.loginBtn.setOnAction(actionEvent -> {
            System.out.println("Login btn 123");
        });
    }
}