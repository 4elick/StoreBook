package com.company.repository;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository{
    List<User> users;

    {users = new ArrayList<>();}

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void deleteById(int id) {
        users.remove(id);
    }

    @Override
    public User findById(int id) {
        try {
            return users.get(id);
        }catch (IndexOutOfBoundsException e){
            System.out.println("You miss p4el");
            return null; /*уточнить насколько это работает*/
        }
    }

    @Override
    public User[] findAll() {
        if(!users.isEmpty()){
            return users.toArray(new User[0]);
        }
        else{
            return new User[0];
        }
    }
}
