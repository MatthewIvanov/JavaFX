module com.example.mywords {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mywords to javafx.fxml;
    exports com.example.mywords;
}