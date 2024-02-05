package src.javafx.models;

import src.javafx.db.Mysql;
import src.javafx.db.MysqlFactory;
import src.javafx.entities.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public User register(String name, String lastName, String login, String password, String country, String language) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + UserModel.TABLE + "(" + UserModel.FIELD_NAME + ","
                + UserModel.FIELD_LAST_NAME + "," + UserModel.FIELD_LOGIN + ","
                + UserModel.FIELD_PASSWORD + "," + UserModel.FIELD_COUNTRY + "," + UserModel.FIELD_LANGUAGE
                + ") VALUES (?,?,?,?,?,?)";

        Mysql mysql = MysqlFactory.create();

        try {
            PreparedStatement statement = mysql.getConnection().prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setString(5, country);
            statement.setString(6, language);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return new User();
    }
}
