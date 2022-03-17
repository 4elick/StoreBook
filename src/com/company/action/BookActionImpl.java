package com.company.action;

import com.company.entity.Author;
import com.company.entity.Book;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.util.Reader;
import com.company.util.Writer;

import java.util.List;

public class BookActionImpl implements BookAction {
    private BookService bookService;
    private AuthorService authorService;
    private Writer writer;
    private Reader reader;

    public BookActionImpl(BookService bookService, AuthorService authorService, Writer writer, Reader reader) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void add() {
        Author author;
        author =  selectAuthor();
        writer.write("Enter book title");
        String title = reader.readString();
        if (bookService.findByTitle(title) == null) {
            bookService.add(new Book(author, title));
        } else {
            writer.write("This book has already been addedd");
        }
    }

    @Override
    public void getById() {
        writer.write("Enter book id to get:");
        int id = reader.readInt();
        Book book = bookService.getById(id);
        if(book != null){
            writer.write(book.getId() + " " + book.getAuthor().getName() + " " + book.getTitle()+ " " + book.getPrice() + "$");
        } else {
            writer.write("No one book has this id");
        }
    }

    @Override
    public void deleteById() {
        writer.write("Enter book id to delete:");
        int id = reader.readInt();
        if(bookService.getById(id)!= null){
            bookService.deleteById(id);
        } else {
            writer.write("No one book has this id");
        }
    }

    @Override
    public void findByTitle() {
        writer.write("Enter title to find book");
        String title = reader.readString();
        Book book = bookService.findByTitle(title);
        if(book != null){
            writer.write(book.getId() + " " + book.getAuthor().getName() + " " + book.getTitle()+ " " + book.getPrice() + "$");
        } else {
            writer.write("No one book has this title");
        }
    }

    @Override
    public void findByAuthor() {
        writer.write("Enter author name to find his books");
        String name = reader.readString();
        Author author = authorService.findByName(name);
        List<Book> books = bookService.findByAuthor(author);
        if(!books.isEmpty()){
            for (Book book : books) {
                writer.write(book.getId() + " " + book.getAuthor().getName() + " " + book.getTitle()+ " " + book.getPrice() + "$");
            }
        } else{
            writer.write("Net takogo");
        }
    }

    @Override
    public void deleteByTitle() {
        writer.write("Enter book title to delete");
        String title = reader.readString();
        if(bookService.findByTitle(title) != null){
            bookService.deleteByTitle(title);
        } else {
            writer.write("No one book has this title");
        }
    }

    @Override
    public void findAll() {
        List<Book> books = bookService.findAll();
        for (Book book : books) {
            writer.write(book.getId() + " " + book.getAuthor().getName() + " " + book.getTitle() + " " + book.getPrice() + "$");
        }
    }

    private Author selectAuthor() {
        writer.write("select an author from the list");
        List<Author> authors = authorService.findAll();
        for (Author author : authors) {
            System.out.println(author.getName());
        }
        String name = reader.readString();
        if (authorService.findByName(name) != null) {
            return authorService.findByName(name);
        } else {
            return null;
        }
    }

}
