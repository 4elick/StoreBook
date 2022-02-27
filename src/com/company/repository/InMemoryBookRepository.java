package com.company.repository;

import com.company.model.Author;
import com.company.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    {
        books = new ArrayList<>();
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public Book getById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int index) {
        books.remove(index);
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        List<Book> temp = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                temp.add(book);
            }
        }
        return temp;
    }

    @Override
    public void deleteByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
