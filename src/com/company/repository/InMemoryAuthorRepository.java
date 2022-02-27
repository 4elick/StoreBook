package com.company.repository;

import com.company.model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorRepository implements AuthorRepository{
    List<Author> authors;
    {authors = new ArrayList<>();}

    @Override
    public void add(Author author) {
          authors.add(author);
    }

    @Override
    public Author getById(int index) {
        for (Author author : authors) {
            if(author.getId() == index){
                return author;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int index){
        authors.remove(index);
    }

    @Override
    public List<Author> findAll() {
        return authors;

    }
}
