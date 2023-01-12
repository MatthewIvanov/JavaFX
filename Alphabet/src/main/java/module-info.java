module com.example.alphabet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alphabet to javafx.fxml;
    exports com.example.alphabet;
}