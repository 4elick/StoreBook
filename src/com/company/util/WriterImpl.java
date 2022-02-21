package com.company.util;

import com.company.model.Author;
import com.company.model.Book;

public class WriterImpl implements Writer{

    @Override
    public void write(String input) {
        System.out.println(input);
    }

    @Override
    public void writeInt(int input) {
        System.out.println(input);
    }

    @Override
    public void writeDouble(double input) {
        System.out.println(input);
    }

    @Override
    public void writeAuthor(Author author) {
        System.out.println(author.getName());
    }

    @Override
    public void writeBook(Book book) {
        System.out.println("Title:"+ book.getTitle() + " Author:" + book.getAuthor().getName());
    }
}
