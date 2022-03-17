package com.company.repository;

import com.company.entity.User;

import java.util.List;

public interface UserRepository {
    void add(User user);
    void deleteById(int id);
    User findById(int id);
    User findByLogin(String login);
    List<User> findAll();
}
