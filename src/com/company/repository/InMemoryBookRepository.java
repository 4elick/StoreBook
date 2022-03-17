package com.company.repository;

import com.company.entity.Author;
import com.company.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;
    private int inc = 0;

    {
        books = new ArrayList<>();
    }

    @Override
    public void add(Book book) {
        book.setId(++inc);
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
        books.remove(--index);

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
            if (book.getAuthor().getName().equals(author.getName())) {
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
