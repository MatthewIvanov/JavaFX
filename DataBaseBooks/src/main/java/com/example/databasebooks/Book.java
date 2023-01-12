package com.example.databasebooks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.beans.property.SimpleStringProperty;

import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book>{
    public String Name;
    public String Author;
    public int  id;

    public Book(String name, String author, int id) {
        Name = name;
        Author = author;
        this.id= id;
    }
    public Book(){}
    @Override
    public int compareTo(Book book) {
        return Name.compareTo(book.Name);
    }
    @Override
    public String toString() {
        return Name;
    }
    static class BookByAuthorComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.Author.compareTo(book2.Author);
        }
    }
    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}


