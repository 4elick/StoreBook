package com.company.model;

public class Author {
    private String name;
    private int age;
    private int id;

    public Author(String name){
        this.name = name;
    }

    public Author(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){ return id;}
}
