package com.company.repository;

import com.company.model.User;

public interface UserRepository {
    void add(User user);
    void deleteById(int id);
    User findById(int id);
    User[] findAll();

}
