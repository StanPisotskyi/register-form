package src.javafx.models;

import src.javafx.db.Mysql;
import src.javafx.db.MysqlFactory;
import src.javafx.entities.User;
import src.javafx.entities.UserFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static final String TABLE = "users";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_LAST_NAME = "last_name";
    public static final String FIELD_LOGIN = "login";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_LANGUAGE = "language";

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

        return this.findOneByLogin(login);
    }

    public User findOneByLogin(String login) throws SQLException, ClassNotFoundException {
        String sql = "SELECT " + UserModel.FIELD_ID + "," + UserModel.FIELD_NAME + "," + UserModel.FIELD_LAST_NAME
                + "," + UserModel.FIELD_LOGIN + "," + UserModel.FIELD_COUNTRY + "," + UserModel.FIELD_LANGUAGE
                + " FROM " + UserModel.TABLE + " WHERE " + UserModel.FIELD_LOGIN + " = ? LIMIT 1";

        Mysql mysql = MysqlFactory.create();

        try {
            PreparedStatement statement = mysql.getConnection().prepareStatement(sql);

            statement.setString(1, login);

            ResultSet res = statement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String lastName = res.getString("last_name");
                String country = res.getString("country");
                String language = res.getString("language");

                return UserFactory.create(id, name, lastName, login, country, language);
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public User findOneByLoginAndPassword(String login, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT " + UserModel.FIELD_ID + "," + UserModel.FIELD_NAME + "," + UserModel.FIELD_LAST_NAME
                + "," + UserModel.FIELD_LOGIN + "," + UserModel.FIELD_COUNTRY + "," + UserModel.FIELD_LANGUAGE
                + " FROM " + UserModel.TABLE + " WHERE " + UserModel.FIELD_LOGIN + " = ? AND " + UserModel.FIELD_PASSWORD + " = ? LIMIT 1";

        Mysql mysql = MysqlFactory.create();

        try {
            PreparedStatement statement = mysql.getConnection().prepareStatement(sql);

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet res = statement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String lastName = res.getString("last_name");
                String country = res.getString("country");
                String language = res.getString("language");

                return UserFactory.create(id, name, lastName, login, country, language);
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
