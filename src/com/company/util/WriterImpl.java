package com.company.util;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.City;

public class WriterImpl implements Writer {

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
        if (author != null) {
            System.out.println(author.getName());
        }
    }

    @Override
    public void writeBook(Book book) {
        System.out.println("Title:" + book.getTitle() + " Author:" + book.getAuthor().getName());
    }

    @Override
    public void writeCity(City city) {
        System.out.println("Name city: " + city.getNameCity() + "Id city: " + city.getId());
    }
}
