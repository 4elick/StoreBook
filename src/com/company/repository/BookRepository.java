package com.company.repository;

import com.company.entity.Author;
import com.company.entity.Book;

import java.util.List;

public interface BookRepository {
     void add(Book book);
     Book getById(int index);
     void deleteById(int index);
     Book findByTitle(String title);
     List <Book> findByAuthor(Author author);
     void deleteByTitle(String title);
     List <Book> findAll();
}
