package com.company.repository;

import com.company.model.Author;
import com.company.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    { books = new ArrayList<>();}

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public Book getByIndex(int index) {
        return books.get(index);
    }

    @Override
    public void deleteByIndex(int index) {
        books.remove(index);
    }

    @Override
    public Book[] findByTitle(String title) {
        List<Book> temp = new ArrayList<>();
        for(int i = 0; i< books.size();i++) {
        if(books.get(i).getTitle().equals(title)){
            temp.add(books.get(i));
        }
        }
        if(temp.isEmpty()){
            System.out.println("No one book has this title^_^");
            return new Book[0];
        }
        else {
            return temp.toArray(new Book[0]);
        }


    }

    @Override
    public Book[] findByAuthor(Author author) {
        return new Book[0];
    }

    @Override
    public void deleteByTitle(String title) {

    }
}
