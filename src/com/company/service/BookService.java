package com.company.service;

import com.company.model.Author;
import com.company.model.Book;

public interface BookService {
    void add(Book book);
    Book getById(int id);
    void deleteById(int id);
    Book findByTitle(String title);
    Book[] findByAuthor(Author author);
    void deleteByTitle(String title);
    Book[] findAll();
}
