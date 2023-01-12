package com.example.translater;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.StringTokenizer;

public class HelloController {


    @FXML
    private TextField first;

    @FXML
    private TextField second;


    @FXML
    void ShowResult(MouseEvent event){
        Dictionary.MakeDictionary();

    StringBuilder builder = new StringBuilder();
    String inputText = first.getText();
    StringTokenizer stringTokenizer = new StringTokenizer(inputText);
    while(stringTokenizer.hasMoreTokens()){
        String token = stringTokenizer.nextToken();
        builder.append(Dictionary.french.get(Dictionary.english.get(token)) + " ");
    }

    second.setText(String.valueOf(builder));
    }
}