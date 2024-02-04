package src.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.javafx.entities.User;
import src.javafx.models.UserModel;

public class MainController extends AbstractController {

    @FXML
    private Button loginBtn;

    @FXML
    private TextField loginInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button registerBtn;

    private final UserModel userModel = new UserModel();

    @FXML
    public void initialize() {
        this.registerBtn.setOnAction(actionEvent -> {
            this.showWindow(this.registerBtn, "register.fxml");
        });

        this.loginBtn.setOnAction(actionEvent -> {
            String loginInput = this.loginInput.getText().trim();
            String passwordInput = this.passwordInput.getText().trim();

            if (!loginInput.isEmpty() && !passwordInput.isEmpty()) {
                User user = this.userModel.login(loginInput, passwordInput);
            }
        });
    }
}