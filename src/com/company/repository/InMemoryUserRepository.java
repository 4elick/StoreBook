package com.company.repository;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users;
    private int inc = 0;

    {
        users = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        user.setId(++inc);
        users.add(user);
    }

    @Override
    public void deleteById(int id) {
        users.remove(--id);

    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
