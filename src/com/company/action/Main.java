package com.company.action;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.City;
import com.company.repository.*;
import com.company.util.Writer;
import com.company.util.WriterImpl;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Writer writer = new WriterImpl();
//        BookRepository books = new InMemoryBookRepository();
//        books.add(new Book(1, new Author("Richard")));
//        books.add(new Book(2, new Author("Richard"),"POshel ya naxui"));
//        books.add(new Book(3, new Author("Fedya")));
//        books.add(new Book(4, new Author("Lars")));
//        Book[] books1 = books.findAll();
//        for(int i = 0; i< books1.length;i++){
//            writer.writeBook(books1[i]);
//        }
//        Book sortByAuthor = books.findByTitle("POshel ya naxui");
//        AuthorRepository a = new InMemoryAuthorRepository();
//        a.add(new Author("Richard", 0));
//        a.add(new Author("Richard", 1));
//        writer.writeAuthor(a.getById(2));
//        Author[] authors = a.findAll();
//        for(int i = 0; i< authors.length; i++){
//            writer.writeAuthor(authors[i]);
//        }
        CityRepository cityRepository = new InMemoryCityRepository();
        cityRepository.add(new City("city", 1));
        System.out.println(cityRepository.getById(2));
    }
}
