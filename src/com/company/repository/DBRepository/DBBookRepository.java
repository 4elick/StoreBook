package com.company.repository.DBRepository;

import com.company.entity.Author;
import com.company.entity.Book;
import com.company.repository.BookRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBBookRepository extends DBAbstractRepository implements BookRepository {
    private final String INSERT_BOOK_INTO = "INSERT INTO books VALUES(default,?,?,?)";
    private final String SELECT_BOOK_BY_ID = "SELECT book_id,author_id,author_name,author_age,book_title,book_price FROM books b " +
            "JOIN authors a ON b.book_author_id = a.author_id " +
            "WHERE book_id = ?";
    private final String SELECT_BOOK_BY_TITLE = "SELECT book_id,author_id,author_name,author_age,book_title,book_price FROM books b " +
            "JOIN authors a ON b.book_author_id = a.author_id " +
            "WHERE book_title = ?";
    private final String SELECT_BOOK_BY_AUTHOR = "SELECT book_id,author_id,author_name,author_age,book_title,book_price FROM books b " +
            "JOIN authors a ON b.book_author_id = a.author_id " +
            "WHERE book_author_id = ?";
    private final String DELETE_BOOK_BY_ID = "DELETE FROM books WHERE book_id = ?";
    private final String DELETE_BOOK_BY_TITLE = "DELETE FROM books WHERE book_title = ?";
    private final String SELECT_ALL = "SELECT book_id,author_id,author_name,author_age,book_title,book_price FROM books b " +
            "JOIN authors a ON b.book_author_id = a.author_id ";

    @Override
    public void add(Book book) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_BOOK_INTO);
            statement.setInt(1, book.getAuthor().getId());
            statement.setInt(2, book.getPrice());
            statement.setString(3, book.getTitle());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Book getById(int index) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            statement.setInt(1, index);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Author author = new Author(resultSet.getString(3), resultSet.getInt(4));
            author.setId(resultSet.getInt(2));
            Book book = new Book(author, resultSet.getString(5));
            book.setPrice(resultSet.getInt(6));
            book.setId(resultSet.getInt(1));
            statement.close();
            return book;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int index) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_BY_ID);
            statement.setInt(1,index);
            statement.execute();
            statement.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public Book findByTitle(String title) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_TITLE);
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Author author = new Author(resultSet.getString(3), resultSet.getInt(4));
            author.setId(resultSet.getInt(2));
            Book book = new Book(author, resultSet.getString(5));
            book.setPrice(resultSet.getInt(6));
            book.setId(resultSet.getInt(1));
            statement.close();
            return book;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_AUTHOR);
            statement.setInt(1,author.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author1 = new Author(resultSet.getString(3), resultSet.getInt(4));
                author1.setId(resultSet.getInt(2));
                Book book = new Book(author1, resultSet.getString(5));
                book.setPrice(resultSet.getInt(6));
                book.setId(resultSet.getInt(1));
                books.add(book);
            }
            statement.close();
            return books;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteByTitle(String title) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_BY_TITLE);
            statement.setString(1,title);
            statement.execute();
            statement.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author1 = new Author(resultSet.getString(3), resultSet.getInt(4));
                author1.setId(resultSet.getInt(2));
                Book book = new Book(author1, resultSet.getString(5));
                book.setPrice(resultSet.getInt(6));
                book.setId(resultSet.getInt(1));
                books.add(book);
            }
            statement.close();
            return books;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
