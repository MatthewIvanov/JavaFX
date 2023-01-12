package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
        @FXML
        private TextField num1;

        @FXML
        private TextField num2;

        @FXML
        private TextField out;

        @FXML
        void ShowResult(MouseEvent event) {
        out.setText(String.valueOf(Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText())));
        }
    }
