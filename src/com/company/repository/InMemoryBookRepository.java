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
    public Book getById(int index) {
         try {
             return books.get(index);
         }catch (IndexOutOfBoundsException e){
             System.err.println(e);
             return null;
         }
    }

    @Override
    public void deleteById(int index) {
        books.remove(index);
    }

    @Override
    public Book findByTitle(String title) {

        for(int i = 0; i< books.size();i++) {
            if(books.get(i).getTitle().isEmpty()){
                continue;
            }
            else {
                if(books.get(i).getTitle().equals(title)){
                    return books.get(i);
                }
            }
        }

            System.out.println("No one book has this title^_^");
            return books.get(0);

    }

    @Override
    public Book[] findByAuthor(Author author) {
        List<Book> temp = new ArrayList<>();
        for(int i = 0; i< books.size(); i++){
            if (books.get(i).getAuthor().equals(author)){
                temp.add(books.get(i));
            }

        }
        if(temp.isEmpty()){
            System.out.println("Don't find this Author ^_^");
            return new Book[0];
        }
        else {
            return temp.toArray(new Book[0]);
        }
    }

    @Override
    public void deleteByTitle(String title) {
    for(int i = 0; i< books.size(); i++){
        if(books.get(i).getTitle().equals(title)){
            books.remove(i);
            return;
        }
    }
       System.out.println("No one book has this title");
    return;
    }

    @Override
    public Book[] findAll() {
        if(!books.isEmpty()){
            return books.toArray(new Book[0]);
        } else {
            return new Book[0];
        }

    }
}
