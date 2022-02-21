package com.company.action;

import com.company.model.Author;
import com.company.model.Book;
import com.company.repository.BookRepository;
import com.company.repository.InMemoryBookRepository;
import com.company.util.Writer;
import com.company.util.WriterImpl;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Writer writer = new WriterImpl();
        BookRepository books = new InMemoryBookRepository();
        books.add(new Book(1, new Author("Richard")));
        books.add(new Book(2, new Author("Richard"),"POshel ya naxui"));
        books.add(new Book(3, new Author("Fedya")));
        books.add(new Book(4, new Author("Lars")));
        Book[] sortByAuthor = books.findByTitle("POshel ya naxui");
        for(int i = 0; i<sortByAuthor.length;i++){
            writer.writeBook(sortByAuthor[i]);
        }
    }
}
