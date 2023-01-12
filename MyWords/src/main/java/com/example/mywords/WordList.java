package com.example.mywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class WordList implements Iterable{
    public ArrayList<Word> words;

    public WordList() {
        words = new ArrayList<Word>();
    }
    public void Add(Word b){
        words.add(b);
    }
    public Word Get(int ind){
        return words.get(ind);
    }
    public void SortByWord(){
        Collections.sort(words);
    }
    public void SortById(){
        Collections.sort(words, new Word.compareById());
    }
    public int BinarySearchByWord(String word) {
        return Collections.binarySearch(words, new Word(null, word), Word::compareTo);
    }
    public int BinarySearchById(Integer id){
        return Collections.binarySearch(words, new Word(id, null), new Word.compareById());
    }
    public void readFromFile(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] wordInf = str.split(" ");
            Word word = new Word(Integer.parseInt(wordInf[0]), wordInf[1]);
            words.add(word);
        }
    }
    @Override
    public Iterator<Word> iterator(){
        return new BookListIterator();
    }
    class BookListIterator implements Iterator<Word>{
        Word nextBook;
        int currentIndex;
        public BookListIterator() {
            nextBook = words.get(0);
            currentIndex = 0;
        }
        @Override
        public boolean hasNext(){
            return currentIndex < words.size();
        }
        @Override
        public Word next() {
            Word result = nextBook;
            if (++currentIndex < words.size()) {
                nextBook = words.get(currentIndex);
            }
            return result;
        }
    }
}
