package com.company.repository;

import com.company.model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorRepository implements AuthorRepository{
    List<Author> authors;
    {authors = new ArrayList<>();}

    @Override
    public void add(Author author) {
          authors.add(author);
    }

    @Override
    public Author getById(int index) {
        try {
            return authors.get(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println("You miss p4el");
            return null; /*уточнить насколько это работает*/
        }
    }

    @Override
    public void deleteById(int index){
        authors.remove(index);
    }

    @Override
    public Author[] findAll() {
        if(!authors.isEmpty()){
            return authors.toArray(new Author[0]);

        }
        else {
            return new Author[0];
        }

    }
}
