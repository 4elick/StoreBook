package com.company.service;

import com.company.model.Author;
import com.company.model.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    Book getById(int id);
    void deleteById(int id);
    Book findByTitle(String title);
    List<Book> findByAuthor(Author author);
    void deleteByTitle(String title);
    List<Book> findAll();
}
