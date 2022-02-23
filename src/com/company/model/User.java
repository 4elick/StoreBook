package com.company.model;

public class User {
    private int id;
    private String password;
    private String login;

    public User(int id,String password, String login){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }
}
