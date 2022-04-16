package com.company.repository.DBRepository;

import com.company.entity.User;
import com.company.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUserRepository extends DBAbstractRepository implements UserRepository {
    private final String INSERT_INTO_USER = "INSERT INTO users VALUES(default,?,?)";
    private final String SELECT_USER_BY_ID = "SELECT* FROM users WHERE user_id = ?";
    private final String SELECT_USER_BY_LOGIN = "SELECT* FROM users WHERE user_login = ?";
    private final String SELECT_ALL = "SELECT* FROM users";
    private final String DELETE_BY_ID = "DELETE FROM users WHERE user_id = ?";


    @Override
    public void add(User user) {
        try{
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
            statement.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getString(3),resultSet.getString(2) );
            user.setId(resultSet.getInt(1));
            statement.close();
            return user;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getString(3),resultSet.getString(2));
            user.setId(resultSet.getInt(1));
            statement.close();
            return user;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getString(3), resultSet.getString(2));
                user.setId(resultSet.getInt(1));
                users.add(user);
            }
            statement.close();
            return users;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
