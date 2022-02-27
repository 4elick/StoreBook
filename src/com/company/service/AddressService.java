package com.company.service;

import com.company.model.Address;

import java.util.List;

public interface AddressService {
    void add(Address address);
    Address getById(int id);
    void deleteById(int id);
    List<Address> findAll();
}
