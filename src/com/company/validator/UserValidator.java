package com.company.validator;

import java.util.regex.Pattern;

public class UserValidator {

    public boolean isValidLogin(String login){
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(EMAIL_PATTERN).matcher(login).matches();
    }

    public boolean isValidPassword(String password){
        final String PASSWORD_PATTERN="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
}
