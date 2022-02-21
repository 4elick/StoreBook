package com.company.model;

public class Book {
     private int id;
     private String title;
     private Author author;

     public Book(int id,Author author){
          this.author = author;
          this.id = id;
          this.title = "";
     }
     public Book(int id,Author author,String title){
          this.author = author;
          this.id = id;
          this.title = title;
     }

     public int getId(){ return id;}

     public String getTitle(){return title;}

     public Author getAuthor(){ return author;}
}
