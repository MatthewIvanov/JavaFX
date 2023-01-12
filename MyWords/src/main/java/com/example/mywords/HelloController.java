package com.example.mywords;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloController {
    public TextField inputLine1;
    public TextField outputLine1;
    @FXML
    private Label welcomeText;
    @FXML
    private Button but;



    public void ShowResult(MouseEvent actionEvent) throws FileNotFoundException, FileNotFoundException {

        ArrayList<Integer> idOfWords = new ArrayList<>();
        var str1 = inputLine1.getCharacters().toString();
        String[] wordsOnEnglish = str1.split(" ");
        String result = "";

        WordList wordLIstEnglish = new WordList();
        wordLIstEnglish.readFromFile("English.txt");
        wordLIstEnglish.SortByWord();

        WordList wordLIstFranch = new WordList();
        wordLIstFranch.readFromFile("French.txt");
        wordLIstFranch.SortById();

        for(String wordOnEnglish: wordsOnEnglish){
            Integer index = wordLIstEnglish.BinarySearchByWord(wordOnEnglish);
            Word someWord = wordLIstEnglish.Get(index);
            idOfWords.add(someWord.id);
        }

        for (Integer id : idOfWords){
            Integer index = wordLIstFranch.BinarySearchById(id);
            Word someWord = wordLIstFranch.Get(index);
            result += someWord.word + " ";
        }
        outputLine1.setText(result);
    }
}