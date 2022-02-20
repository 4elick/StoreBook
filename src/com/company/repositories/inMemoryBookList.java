package com.company.repositories;

import com.company.model.Book;

import java.util.ArrayList;
import java.util.List;

public class inMemoryBookList implements BookList{

    @Override
    public List<Book> createBookList() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public List<Book> addBookList(List<Book> books,Book book) {
        books.add(book);
        return books;
    }

    @Override
    public Book readBookList(List<Book> books,int index) {
        return books.get(index);
    }

    @Override
    public List<Book> deleteBook(List<Book> books, int id) {
        books.remove(id);
        return books;
    }
}
