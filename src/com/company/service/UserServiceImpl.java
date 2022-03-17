package com.company.service;

import com.company.entity.User;
import com.company.repository.InMemoryUserRepository;
import com.company.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    {
        userRepository = new InMemoryUserRepository();
    }
    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
