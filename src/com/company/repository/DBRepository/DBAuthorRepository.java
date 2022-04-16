package com.company.repository.DBRepository;

import com.company.entity.Author;
import com.company.repository.AuthorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAuthorRepository extends DBAbstractRepository implements AuthorRepository {
    private final String INSERT_INTO_AUTHOR = "INSERT INTO authors VALUES(default,?,?)";
    private final String SELECT_AUTHOR_BY_ID = "SELECT* FROM authors WHERE author_id = ?";
    private final String SELECT_ALL = "SELECT* FROM authors";
    private final String SELECT_AUTHOR_BY_NAME = "SELECT* FROM authors WHERE author_name = ?";
    private final String DELETE_AUTHOR_BY_ID = "DELETE FROM authors WHERE author_id = ?";

    @Override
    public void add(Author author) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_AUTHOR);
            statement.setInt(1, author.getAge());
            statement.setString(2, author.getName());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Author getById(int index) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_AUTHOR_BY_ID);
            statement.setInt(1, index);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Author author = new Author(resultSet.getString(3), resultSet.getInt(2));
            author.setId(index);
            statement.close();
            return author;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int index) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR_BY_ID);
            statement.setInt(1, index);
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString(3), resultSet.getInt(2));
                author.setId(resultSet.getInt(1));
                authors.add(author);
            }
            statement.close();
            return authors;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Author findByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_AUTHOR_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Author author = new Author(resultSet.getString(3), resultSet.getInt(2));
            author.setId(resultSet.getInt(1));
            statement.close();
            return author;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
