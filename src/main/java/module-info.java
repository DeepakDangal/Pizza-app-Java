module com.example.csd214_test3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.csd214_test3 to javafx.fxml;
    exports com.example.csd214_test3;
    exports com.example.csd214_test3.model;
    opens com.example.csd214_test3.model to javafx.fxml;
}