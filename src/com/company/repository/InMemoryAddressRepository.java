package com.company.repository;

import com.company.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddressRepository implements AddressRepository {
    List<Address> addresses;
    private int inc = 0;

    {
        addresses = new ArrayList<>();
    }

    @Override
    public void add(Address address) {
        address.setId(++inc);
        addresses.add(address);
    }

    @Override
    public Address getById(int id) {
        for (Address address : addresses) {
            if (address.getId() == id) {
                return address;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        addresses.remove(--id);

    }

    @Override
    public List<Address> findAll() {
        return addresses;
    }

    @Override
    public Address findByPlace(String place) {
        for (Address address : addresses) {
            if(address.getStreet().equals(place)){
                return address;
            }
        }
        return null;
    }
}
