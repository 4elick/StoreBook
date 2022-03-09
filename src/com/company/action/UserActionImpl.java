package com.company.action;

import com.company.model.User;
import com.company.service.UserService;
import com.company.util.Reader;
import com.company.util.Writer;
import com.company.validator.UserValidator;

import java.util.List;

public class UserActionImpl implements UserAction{
    private Writer writer;
    private Reader reader;
    private UserService userService;
    private UserValidator userValidator;

    public UserActionImpl(Writer writer, Reader reader, UserService userService,UserValidator userValidator) {
        this.writer = writer;
        this.reader = reader;
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @Override
    public void add() {
        writer.write("enter login to create account");
        String login = reader.readString();
        if(!userValidator.isValidLogin(login)){
           writer.write("Incorrect login");
        }
        writer.write("Enter password");
        String password = reader.readString();
        if(!userValidator.isValidPassword(password)){
            writer.write("Incorrect password");
        }
        userService.add(new User(password,login));
    }

    @Override
    public void deleteById() {
        writer.write("Enter id to delete user");
        int id =reader.readInt();
        if(userService.findById(id)!=null){
            userService.deleteById(id);
        } else {
            writer.write("No one user has this id");
        }
    }

    @Override
    public void findById() {
        writer.write("Enter id to find user");
        int id =reader.readInt();
        if(userService.findById(id)!=null){
            User user = userService.findById(id);
            writer.write(user.getId() + " " + user.getLogin());
        } else {
            writer.write("No one user has this id");
        }
    }

    @Override
    public void findByLogin() {
        writer.write("Enter login to find the user");
        String login = reader.readString();
        if(userService.findByLogin(login)!= null){
            User user = userService.findByLogin(login);
            writer.write(user.getId() + " " + user.getLogin());
        } else {
            writer.write("No one user has this login");
        }
    }

    @Override
    public void findAll() {
        List<User> users = userService.findAll();
        for (User user : users) {
            writer.write(user.getId() + " " + user.getLogin());
        }
    }
}
