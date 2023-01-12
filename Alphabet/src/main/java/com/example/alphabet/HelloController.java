package com.example.alphabet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField first;

    @FXML
    private TextField second;

    @FXML
    void ShowResult(MouseEvent event) throws FileNotFoundException {

        String str = first.getCharacters().toString();
        String[] Letters = str.split(" ");
        String result = "";

        LetterList list = new LetterList();
        list.readFromFile("Numbers.txt");
        list.SortById();
        for(var temp: Letters){
            String  index = list.BinarySearchById(Integer.parseInt(temp));
            if (index ==  "-" ){
                result += "-";
            }else {
            Letter currentLetter = list.Get(Integer.parseInt(index));
            result += currentLetter.letter ;
            }
        }

        second.setText(result);
    }

    }
