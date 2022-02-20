package com.company.repository;

import com.company.model.Author;
import com.company.model.Book;

import java.util.List;

public interface BookRepository {
     void add(Book book);
     Book getByIndex(int index);
     void deleteByIndex(int index);
     Book[] findByTitle(String title);
     Book[] findByAuthor(Author author);
     void deleteByTitle(String title);
}
