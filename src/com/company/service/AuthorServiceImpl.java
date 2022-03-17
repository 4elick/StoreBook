package com.company.service;

import com.company.entity.Author;
import com.company.repository.AuthorRepository;
import com.company.repository.InMemoryAuthorRepository;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    private AuthorRepository authorRepository;

    {authorRepository = new InMemoryAuthorRepository();}

    @Override
    public void add(Author author) {
        authorRepository.add(author);
    }

    @Override
    public Author getById(int id) {
        return authorRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }
}
