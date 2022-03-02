package com.company.model;

public class Book {
    private int id;
    private String title;
    private Author author;

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }
}
