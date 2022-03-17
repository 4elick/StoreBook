package com.company.service;

import com.company.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void deleteById(int id);
    User findById(int id);
    User findByLogin(String login);
    List<User> findAll();
}
