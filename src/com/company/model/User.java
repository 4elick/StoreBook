package com.company.model;

import java.util.List;

public class User {
    private int id;
    private String password;
    private String login;

    public User(String password, String login) {
        this.login = login;

        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
