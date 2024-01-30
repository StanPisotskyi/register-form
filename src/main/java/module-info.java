module src.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.javafx to javafx.fxml;
    exports src.javafx;
}