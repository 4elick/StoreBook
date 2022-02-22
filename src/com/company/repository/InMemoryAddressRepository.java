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
        try {
            return addresses.get(id);
        }catch (IndexOutOfBoundsException e){
            System.out.println("You miss p4el");
            return null; /*уточнить насколько это работает*/
        }
    }

    @Override
    public void deleteById(int id) {
        addresses.remove(id);
    }

    @Override
    public Address[] findAll() {
        if(!addresses.isEmpty()){
            return addresses.toArray(new Address[0]);
        }
        else{
            return new Address[0];
        }
    }
}
