package com.company.action;

import com.company.service.BookService;
import com.company.util.Reader;
import com.company.util.Writer;

import java.util.ArrayList;

public class BasketActionImpl implements BasketAction{
    private BookService bookService;
    private Writer writer;
    private Reader reader;

    public BasketActionImpl(BookService bookService, Writer writer, Reader reader) {
        this.bookService = bookService;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void addBookInBasket() {
        writer.write("Enter book id to add in your basket: ");
        int id = reader.readInt();
        ConsoleApplicationImpl.activateSession.getBasket().addBook(bookService.getById(id));
    }

    @Override
    public void deleteBookFromBasket() {
        writer.write("Enter book id to delete it from your basket: ");
        int id = reader.readInt();
        ConsoleApplicationImpl.activateSession.getBasket().getBooks().remove(--id);
    }

}
