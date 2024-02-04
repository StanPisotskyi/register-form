package src.javafx.models;

import src.javafx.entities.User;

public class UserModel {
    public static final String TABLE = "users";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_LAST_NAME = "last_name";
    public static final String FIELD_LOGIN = "login";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_LANGUAGE = "language";

    public User login (String login, String password) {
        return new User();
    }
}
