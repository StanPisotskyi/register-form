module src.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens src.javafx to javafx.fxml;
    exports src.javafx;
}