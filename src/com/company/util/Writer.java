package com.company.util;

import com.company.model.Author;
import com.company.model.Book;

public interface Writer {
    void write(String input);
    void writeInt(int input);
    void writeDouble(double input);
    void writeAuthor(Author author);
    void writeBook(Book book);
}
