package src.javafx.db;

import java.sql.SQLException;

public class MysqlFactory {
    private static Mysql mysql;

    public static Mysql create() throws SQLException, ClassNotFoundException {
        if (mysql == null) {
            Mysql connection = new Mysql("localhost", "3306", "root", "123123", "javafx");

            mysql = connection.createConnection();
        }

        return mysql;
    }
}
