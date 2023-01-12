module com.example.tablebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.tablebook to javafx.fxml;
    exports com.example.tablebook;
}