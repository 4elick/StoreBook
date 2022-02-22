package com.company.repository;

import com.company.model.Author;
import com.company.model.Book;

public interface AuthorRepository {
    void add(Author author);
    Author getById(int index);
    void deleteById(int index);
    Author[] findAll();
}
