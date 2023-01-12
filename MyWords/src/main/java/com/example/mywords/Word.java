package com.example.mywords;

import java.util.Comparator;
public class Word implements Comparable<Word> {
        public Integer id;
        public String word;


        public Word(Integer id, String word) {
            this.id = id;
            this.word = word;
        }

        @Override
        public String toString() {
            return id + " " + word;
        }

        @Override
        public int compareTo(Word o) {
            return word.compareTo(o.word);
        }

        static class compareById implements Comparator<Word> {
            @Override
            public int compare(Word o1, Word o2) {
                return Integer.compare(o1.id, o2.id);
            }
        }
    }



