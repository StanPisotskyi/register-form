package src.javafx.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Mysql extends AbstractConnection {
    Connection connection;

    public Mysql(String host, String port, String user, String password, String db) {
        super(host, port, user, password, db);
    }

    public Mysql createConnection() throws ClassNotFoundException, SQLException {
        String params = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.db;

        Class.forName("com.mysql.jdbc.Driver");

        this.connection = DriverManager.getConnection(params, this.user, this.password);

        return this;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
