package com.company.validator;

public class AuthorValidator {
    public boolean isValidAuthorName(String name) {
        return name.length() > 2;
    }

    public boolean isPositiveNumber(int id) {
        return id > 0;
    }
}
