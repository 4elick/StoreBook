package com.company.service;

import com.company.model.Author;
import com.company.model.Book;
import com.company.repository.BookRepository;
import com.company.repository.InMemoryBookRepository;

public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    {
        bookRepository = new InMemoryBookRepository();
    }

    @Override
    public void add(Book book) {
        bookRepository.add(book);
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book[] findByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public void deleteByTitle(String title) {
        bookRepository.deleteByTitle(title);
    }

    @Override
    public Book[] findAll() {
        return bookRepository.findAll();
    }
}
