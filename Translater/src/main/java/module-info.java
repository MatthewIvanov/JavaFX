module com.example.translater {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.translater to javafx.fxml;
    exports com.example.translater;
}