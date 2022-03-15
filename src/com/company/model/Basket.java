package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int id;
    private List<Book> books = new ArrayList<>();

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }
}
