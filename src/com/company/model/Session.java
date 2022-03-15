package com.company.model;

import java.util.List;

public class Session {
    private  int id;
    private User user;
    private Basket basket;

    public Session(User user, Basket basket){
        this.user = user;
        this.basket = basket;
    }

    public User getUser(){
        return user;
    }

    public Basket getBasket(){
        return basket;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void addBookInBasket(Book book){
        basket.addBook(book);
    }
}
