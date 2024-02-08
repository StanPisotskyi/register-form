module src.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;


    opens src.javafx to javafx.fxml;
    exports src.javafx;
    exports src.javafx.entities;
}