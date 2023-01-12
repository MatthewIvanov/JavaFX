package com.example.tablebook;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private ObservableList<Book>  list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Book, String> col1;

    @FXML
    private TableColumn<Book, String> col2;

    @FXML
    public TableView<Book> table;

    public HelloController() throws IOException {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col1.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
        col2.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));

        BookList list2 = new BookList();
        try {
            list2.ReadFromJsonFile("txt.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.addAll(list2.Books);
        table.setItems(list);
    }
}
// SetOnEditCommit