package com.example.alphabet;

import java.util.Comparator;

public class Letter implements Comparable<Letter> {
    public Integer id;
    public String letter;


    public Letter(Integer id, String word) {
        this.id = id;
        this.letter = word;
    }

    @Override
    public String toString() {
        return id + " " + letter;
    }

    @Override
    public int compareTo(Letter o) {
        return letter.compareTo(o.letter);
    }

    static class compareById implements Comparator<Letter> {
        @Override
        public int compare(Letter o1, Letter o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }
}
