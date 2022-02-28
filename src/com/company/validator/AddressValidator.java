package com.company.validator;

public class AddressValidator {
    public boolean isValidAddressName(String address) {
        return address.length() > 2;
    }

    public boolean isPositiveNumber(int id) {
        return id > 0;
    }
}
