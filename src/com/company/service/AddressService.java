package com.company.service;

import com.company.model.Address;

public interface AddressService {
    void add(Address address);
    Address getById(int id);
    void deleteById(int id);
    Address[] findAll();
}
