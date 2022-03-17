package com.company.service;

import com.company.entity.Author;

import java.util.List;

public interface AuthorService {
    void add(Author author);
    Author getById(int id);
    void deleteById(int id);
    List<Author> findAll();
    Author findByName(String name);
}
