package com.example.alphabet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class LetterList implements Iterable{
public ArrayList<Letter> letters;

public LetterList() {
        letters = new ArrayList<Letter>();
        }
public void Add(Letter obj){
        letters.add(obj);
        }
public Letter Get(int ind){
        return letters.get(ind);
        }
public void SortByWord(){
        Collections.sort(letters);
        }
public void SortById(){
        Collections.sort(letters, new Letter.compareById());
        }

public String   BinarySearchById(Integer id){
        int i = Collections.binarySearch(letters, new Letter(id, null), new Letter.compareById());
        if(i<0){
            return "-";
        }else{
            return String.valueOf(i);
        }
}
public void readFromFile(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
        String str = scanner.nextLine();
        String[] LetterInf = str.split(" ");
        Letter letter = new Letter(Integer.parseInt(LetterInf[0]), LetterInf[1]);
        letters.add(letter);
        }
}
@Override
public Iterator<Letter> iterator(){
        return new LetterListIterator();
        }
class LetterListIterator implements Iterator<Letter> {
    Letter next;
    int currentIndex;
    public LetterListIterator() {
        next = letters.get(0);
        currentIndex = 0;
    }
    @Override
    public boolean hasNext(){
        return currentIndex < letters.size();
    }
    @Override
    public Letter next() {
        Letter result = next;

        if (++currentIndex < letters.size()) {
            next = letters.get(currentIndex);
        }
        return result;
    }
}
}