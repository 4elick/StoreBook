package com.company.repository;

import com.company.model.Address;

import java.util.List;

public interface AddressRepository {
    void add(Address address);
    Address getById(int id);
    void deleteById(int id);
    List<Address> findAll();
}
