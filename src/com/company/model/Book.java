package com.company.model;

public class Book {
     private int id;
     private String title;
     private Author author;

     public Book(int id,Author author){
          this.author = author;
          this.id = id;
     }

     public int getId(){ return id;}

     public Author getAuthor(){ return getAuthor();}
}
