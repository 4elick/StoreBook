package com.company.repository;

import com.company.model.Address;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddressRepository implements AddressRepository{
    List<Address> addresses;

    {addresses = new ArrayList<>();}

    @Override
    public void add(Address address) {
        addresses.add(address);
    }

    @Override
    public Address getById(int id) {
        for (Address address : addresses) {
            if(address.getId() == id){
                return address;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        addresses.remove(id);
    }

    @Override
    public List<Address> findAll() {
        return addresses;
    }
}
