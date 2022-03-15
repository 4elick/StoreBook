package com.company.action;

import com.company.model.Basket;
import com.company.model.Session;
import com.company.model.User;
import com.company.service.SessionService;
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
    private SessionService sessionService;

    public UserActionImpl(Writer writer, Reader reader, UserService userService, UserValidator userValidator, SessionService sessionService) {
        this.writer = writer;
        this.reader = reader;
        this.userService = userService;
        this.userValidator = userValidator;
        this.sessionService = sessionService;
    }

    @Override
    public void registration(){
        while(true) {
            writer.write("Enter e-mail to create account");
            String login = reader.readString();
            if (!userValidator.isValidLogin(login)) {
                writer.write("Invalid e-mail");
            } else {
                writer.write("Enter password");
                String password = reader.readString();
                if (!userValidator.isValidPassword(password)) {
                    writer.write("Invalid password");
                } else {
                    User user = new User(password, login);
                    userService.add(user);
                    sessionService.add(new Session(user,new Basket()));
                    return;
                }
            }

        }
    }

    @Override
    public void authorization() {
        while (true) {
            writer.write("Enter e-mail to join:");
            String login = reader.readString();
            if (!userValidator.isValidLogin(login)) {
                writer.write("Invalid e-mail");
                continue;
            }

            if(userService.findByLogin(login) == null){
                writer.write("User with this email does not exist");
                continue;
            }
            User user = userService.findByLogin(login);
            writer.write("Enter password:");
            String password = reader.readString();
            if(!userValidator.isValidPassword(password)){
                writer.write("Invalid password");
                continue;
            }
            if(user.getPassword().equals(password)){
                ConsoleApplicationImpl.activateSession = sessionService.getByUser(user);
                writer.write("Welcome" + user.getLogin());
                return;
            }else {
                writer.write("Incorrect password");
            }

        }
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
