package com.company.model;

public class Author {
    private String name;
    private int age;
    private int id;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Author author) {
        if (this.name.equals(author.getName())) {
            return true;
        } else {
            return false;
        }

    }
}
