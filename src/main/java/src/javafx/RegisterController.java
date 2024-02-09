package src.javafx;

import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.javafx.datatransfer.Storage;
import src.javafx.entities.User;
import src.javafx.helpers.HashHelper;
import src.javafx.models.UserModel;

import java.sql.SQLException;

import com.fasterxml.jackson.databind.*;

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
            String name = this.nameInput.getText();
            String lastName = this.lastNameInput.getText();
            String login = this.loginInput.getText();
            String password = HashHelper.generate(this.passwordInput.getText());
            String country = this.countryInput.getText();
            String language = this.languageInput.getText();

            if (this.isValid() && this.isConfirmed.isSelected() && !this.userExists(login)) {
                try {
                    User user = this.userModel.register(name, lastName, login, password, country, language);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(user);
                    Storage.create("test").add("userData", json);

                    this.showWindow(this.registerBtn, "profile.fxml");
                } catch (SQLException | ClassNotFoundException | JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private boolean isValid() {
        return !this.nameInput.getText().isEmpty() && !this.lastNameInput.getText().isEmpty()
                && !this.loginInput.getText().isEmpty() && !this.passwordInput.getText().isEmpty();
    }

    private boolean userExists(String login) {
        try {
            User user = userModel.findOneByLogin(login);

            return user != null;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
