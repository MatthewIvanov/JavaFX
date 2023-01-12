package com.example.sum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class HelloController {

        @FXML
        private TextField number1;

        @FXML
        private TextField number2;

        @FXML
        private Text out;

        @FXML
        void onActionClicked(ActionEvent event) {
            out.setText("Hello");
        }
    }
