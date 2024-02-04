package src.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController extends AbstractController {

    public Button backBtn;
    @FXML
    private TextField countryInput;

    @FXML
    private CheckBox isConfirmed;

    @FXML
    private TextField languageInput;

    @FXML
    private TextField latNameInput;

    @FXML
    private TextField loginInput;

    @FXML
    private TextField nameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button registerBtn;

    public void initialize() {
        this.backBtn.setOnAction(actionEvent -> {
            this.showWindow(this.registerBtn, "app.fxml");
        });
    }
}