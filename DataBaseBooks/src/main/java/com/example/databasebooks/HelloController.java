package com.example.databasebooks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.Collection;

public class HelloController {
    private ObservableList<Book> list = FXCollections.observableArrayList();
    @FXML
    private TextField Book;

    @FXML
    private TextField author;
    @FXML
    private TextField ind;
    @FXML
    private TableColumn<Book, String> col1;

    @FXML
    private TableColumn<Book, String> col2;
    @FXML
    private TableColumn<Book, Integer> col3;

    @FXML
    private TableView<Book> table;

    private int count = 1;
    @FXML
    void Add(MouseEvent event) throws SQLException {
        DbHandler obj= new DbHandler();
        obj.create2();
        obj.DeleteAllBooks();
        Book book = new Book(Book.getText(),author.getText(),count++);
        obj.addBook(book);
        obj.getAllBooks();
        col1.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
        col2.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        col3.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));

        list.addAll(obj.getAllBooks().Books);
        table.setItems(list);

    }
    @FXML
    void Update(MouseEvent event) throws SQLException {
        DbHandler obj = new DbHandler();
        obj.create2();
        obj.getAllBooks();
        col1.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
        col2.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        col3.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        obj.UpdateBook(String.valueOf(Integer.parseInt(ind.getText())-1), Book.getText(), author.getText());

        list.addAll(obj.getAllBooks().Books);
        table.setItems(list);



    }

}