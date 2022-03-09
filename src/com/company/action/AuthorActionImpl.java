package com.company.action;

import com.company.model.Author;
import com.company.service.AuthorService;
import com.company.service.AuthorServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.AuthorValidator;

import java.util.List;

public class AuthorActionImpl implements AuthorAction {
    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private AuthorService authorService = new AuthorServiceImpl();
    private AuthorValidator authorValidator = new AuthorValidator();

    @Override
    public void add() {
        writer.write("Enter author name: ");
        String authorName = reader.readString();
        if (!authorValidator.isValidAuthorName(authorName)) {
            writer.write("Incorrect input");
            return;
        }
        if (!checkAuthor(authorName)) {
            System.out.println("Author with this name has already been added");
            return;
        }
        System.out.println("Enter age");
        int age = reader.readInt();
        if (authorValidator.isPositiveNumber(age)) {
            authorService.add(new Author(authorName, age));
            findAll();
        }
    }

    @Override
    public void getById() {
        writer.write("Enter id to get Author: ");
        int id = reader.readInt();
        if (!authorValidator.isPositiveNumber(id)) {
            writer.write("Incorrect input!");
            return;
        }
        Author author = authorService.getById(id);
        if (author != null) {
            writer.write(id + " " + authorService.getById(id).getName() + " " + authorService.getById(id).getAge());
        } else {
            writer.write("No one Author has this id!");
        }
    }

    @Override
    public void deleteById() {
        writer.write("Enter id to delete Author: ");
        int id = reader.readInt();
        if (!authorValidator.isPositiveNumber(id)) {
            writer.write("Incorrect input!");
            return;
        }
        if (authorService.getById(id) != null) {
            authorService.deleteById(id);
        } else {
            writer.write("No one Author has this id!");
        }

    }

    @Override
    public void findAll() {
        List<Author> authors = authorService.findAll();
        for (Author author : authors) {
            System.out.println("First name author: " + author.getName() + " age author" + author.getAge() + " id author" + author.getId());
        }
    }

    @Override
    public void findByName() {
        writer.write("Enter author name: ");
        String name = reader.readString();
        Author author = authorService.findByName(name);
        if(author!= null){
            writer.write(author.getId() + " "+ author.getName() + " " + author.getAge());
        } else {
            writer.write("No one Author has this name!");
        }
    }

    private boolean checkAuthor(String name) {
        return authorService.findByName(name) == null;
    }
}
