package com.company.service;

import com.company.model.Author;

public interface AuthorService {
    void add(Author author);
    Author getById(int id);
    void deleteById(int id);
    Author[] findAll();
}
