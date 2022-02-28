package com.company.validator;

public class CityValidator {
    public boolean isValidCityName(String string) {
        return string.length() > 2;
    }

    public boolean isPositiveNumber(int id) {
        return id > 0;
    }
}
