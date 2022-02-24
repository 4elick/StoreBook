package com.company.service;

import com.company.model.User;

public interface UserService {
    void add(User user);
    void deleteById(int id);
    User findById(int id);
    User findByLogin(String login);
    User[] findAll();
}
