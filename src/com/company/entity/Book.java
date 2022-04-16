package com.company.entity;

import java.util.Random;

public class Book {
    private int id;
    private String title;
    private Author author;
    private int price;
    private Random random = new Random();

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
        price = random.nextInt(10,20);
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
    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author.getName() + '\'' +
                ", price=" + price +
                '}';
    }
}
