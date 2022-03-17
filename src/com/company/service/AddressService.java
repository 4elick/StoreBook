package com.company.service;

import com.company.entity.Address;

import java.util.List;

public interface AddressService {
    void add(Address address);
    Address getById(int id);
    void deleteById(int id);
    List<Address> findAll();
    Address findByStreet(String place);
}
