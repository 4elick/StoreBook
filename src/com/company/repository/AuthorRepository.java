package com.company.repository;

import com.company.entity.Author;

import java.util.List;

public interface AuthorRepository {
    void add(Author author);
    Author getById(int index);
    void deleteById(int index);
    List<Author> findAll();
    Author findByName(String name);
}
