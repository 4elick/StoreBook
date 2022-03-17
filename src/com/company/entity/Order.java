package com.company.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private List<Book> books;
    private Store store;
    private Address address;
    private User user;
    private int totalPrice;
    private Date date = Calendar.getInstance().getTime();

    public Order( List<Book> books, Store store, Address address, User user, Date date) {

        this.books = books;
        this.store = store;
        this.address = address;
        this.user = user;
        this.date = date;
    }

    public Order(List<Book> books, Address address, User user) {
        this.books = books;
        this.address = address;
        this.user = user;
    }

    public Order(List<Book> books, Store store, User user) {
        this.books = books;
        this.store = store;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotalPrice(){
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
