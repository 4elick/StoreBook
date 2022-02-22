package com.company.repository;

import com.company.model.Address;

public interface AddressRepository {
    void add(Address address);
    Address getById(int id);
    void deleteById(int id);
    Address[] findAll();
}
