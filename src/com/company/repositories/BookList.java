package com.company.repositories;

import com.company.model.Book;

import java.util.List;

public interface BookList {
    public List<Book> createBookList();
    public List<Book> addBookList(List<Book> books, Book book);
    public Book readBookList(List<Book> books,int index);
    public List<Book> deleteBook(List<Book> books,int id);
}
