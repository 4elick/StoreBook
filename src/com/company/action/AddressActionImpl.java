package com.company.action;

import com.company.model.Address;
import com.company.repository.AddressRepository;
import com.company.repository.InMemoryAddressRepository;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.AddressValidator;

public class AddressActionImpl implements AddressAction{
    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private AddressService addressService = new AddressServiceImpl();
    private AddressValidator addressValidator = new AddressValidator();

    public AddressActionImpl(Writer writer, Reader reader, AddressService addressService, AddressValidator addressValidator) {
        this.writer = writer;
        this.reader = reader;
        this.addressService = addressService;
        this.addressValidator = addressValidator;
    }

    @Override
    public void add() {
        writer.write("Input address");
        String address = reader.readString();
        if(!addressValidator.isValidAddressName(address)){
            writer.write("Incorrect input");
            return;
        }

    }

    @Override
    public void getById() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public void findAll() {

    }

    //private boolean checkAddress(String address) {
      //  return addressServicefindByName(address) == null;
    //}
}
