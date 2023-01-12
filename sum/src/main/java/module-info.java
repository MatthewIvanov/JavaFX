module com.example.sum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sum to javafx.fxml;
    exports com.example.sum;
}