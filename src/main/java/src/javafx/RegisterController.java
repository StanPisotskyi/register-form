package src.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.javafx.entities.User;
import src.javafx.helpers.HashHelper;
import src.javafx.models.UserModel;

import java.sql.SQLException;

public class RegisterController extends AbstractController {

    public Button backBtn;
    @FXML
    private TextField countryInput;

    @FXML
    private CheckBox isConfirmed;

    @FXML
    private TextField languageInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField loginInput;

    @FXML
    private TextField nameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button registerBtn;

    private final UserModel userModel = new UserModel();

    public void initialize() {
        this.backBtn.setOnAction(actionEvent -> {
            this.showWindow(this.registerBtn, "app.fxml");
        });

        this.registerBtn.setOnAction(actionEvent -> {
            if (this.isValid() && this.isConfirmed.isSelected()) {
                String name = this.nameInput.getText();
                String lastName = this.lastNameInput.getText();
                String login = this.loginInput.getText();
                String password = HashHelper.generate(this.passwordInput.getText());
                String country = this.countryInput.getText();
                String language = this.languageInput.getText();

                try {
                    User user = this.userModel.register(name, lastName, login, password, country, language);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private boolean isValid() {
        return !this.nameInput.getText().isEmpty() && !this.lastNameInput.getText().isEmpty()
                && !this.loginInput.getText().isEmpty() && !this.passwordInput.getText().isEmpty();
    }
}
