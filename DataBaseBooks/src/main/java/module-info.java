module com.example.databasebooks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.databasebooks to javafx.fxml;
    exports com.example.databasebooks;
}