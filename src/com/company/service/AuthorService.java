package com.company.service;

import com.company.model.Author;

import java.util.List;

public interface AuthorService {
    void add(Author author);
    Author getById(int id);
    void deleteById(int id);
    List<Author> findAll();
}
