package com.company.repository;

import com.company.model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorRepository implements AuthorRepository {
    List<Author> authors;
    private int inc = 0;

    {
        authors = new ArrayList<>();
    }

    @Override
    public void add(Author author) {
        author.setId(++inc);
        authors.add(author);
    }

    @Override
    public Author getById(int index) {
        for (Author author : authors) {
            if (author.getId() == index) {
                return author;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int index) {
        authors.remove(--index);

    }

    @Override
    public List<Author> findAll() {
        return authors;

    }

    @Override
    public Author findByName(String name) {
        for (Author author : authors) {
            if(author.getName().equals(name)){
                return author;
            }
        }
        return null;
    }
}
