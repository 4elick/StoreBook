package com.company.service;

import com.company.model.Address;
import com.company.repository.AddressRepository;
import com.company.repository.InMemoryAddressRepository;

import java.util.List;

public class AddressServiceImpl implements AddressService{
   private AddressRepository addressRepository;

    {   addressRepository = new InMemoryAddressRepository();    }

    @Override
    public void add(Address address) {
        addressRepository.add(address);
    }

    @Override
    public Address getById(int id) {
        return addressRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findByPlace(String place) {
        return addressRepository.findByPlace(place);
    }
}
