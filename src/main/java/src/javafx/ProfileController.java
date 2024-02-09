package src.javafx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import src.javafx.datatransfer.Storage;
import src.javafx.entities.User;

public class ProfileController extends AbstractController {

    @FXML
    private Label countryLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label languageLabel;

    @FXML
    private Label loginLabel;

    @FXML
    private Button logoutBtn;

    public void initialize() {
        try {
            String userData = Storage.create("test").get("userData");
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(userData, User.class);

            String country = "-";
            String language = "-";

            if (!user.getCountry().isEmpty()) {
                country = user.getCountry();
            }

            if (!user.getLanguage().isEmpty()) {
                language = user.getLanguage();
            }

            this.loginLabel.setText(this.loginLabel.getText() + " " + user.getLogin());
            this.fullNameLabel.setText(this.fullNameLabel.getText() + " " + user.getName() + " " + user.getLastName());
            this.countryLabel.setText(this.countryLabel.getText() + " " + country);
            this.languageLabel.setText(this.languageLabel.getText() + " " + language);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.logoutBtn.setOnAction(actionEvent -> {
            this.showWindow(this.logoutBtn, "app.fxml");
        });
    }
}
