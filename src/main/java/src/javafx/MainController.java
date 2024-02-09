package src.javafx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.javafx.datatransfer.Storage;
import src.javafx.entities.User;
import src.javafx.helpers.HashHelper;
import src.javafx.models.UserModel;

import java.sql.SQLException;

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
                try {
                    User user = this.userModel.findOneByLoginAndPassword(loginInput, HashHelper.generate(passwordInput));

                    if (user != null) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        String json = objectMapper.writeValueAsString(user);
                        Storage.create("test").add("userData", json);

                        this.showWindow(this.registerBtn, "profile.fxml");
                    }
                } catch (SQLException | ClassNotFoundException | JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}