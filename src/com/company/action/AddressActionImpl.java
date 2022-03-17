package com.company.action;

import com.company.entity.Address;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;
import com.company.service.CityService;
import com.company.service.CityServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.AddressValidator;

import java.util.List;

public class AddressActionImpl implements AddressAction {

    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private AddressService addressService = new AddressServiceImpl();
    private AddressValidator addressValidator = new AddressValidator();
    private CityService cityService = new CityServiceImpl();

    public AddressActionImpl(Writer writer, Reader reader, AddressService addressService, AddressValidator addressValidator, CityService cityService) {
        this.writer = writer;
        this.reader = reader;
        this.addressService = addressService;
        this.addressValidator = addressValidator;
        this.cityService = cityService;
    }

    @Override
    public void add() {
        writer.write("Enter street");
        String address = reader.readString();
        if (!addressValidator.isValidAddressName(address)) {
            writer.write("Incorrect input");
            return;
        }
        if (checkAddress(address)) {
            addressService.add(new Address(address));
        } else {
            writer.write("This address has already been added");
        }

    }

    @Override
    public void getById() {
        writer.write("Enter id address: ");
        int id = reader.readInt();
        if (addressValidator.isPositiveNumber(id)) {
            writer.write(  "address: " + addressService.getById(id).getStreet());
        }
    }

    @Override
    public void deleteById() {
        writer.write("Enter id to delete address: ");
        int id = reader.readInt();
        if (!addressValidator.isPositiveNumber(id)) {
            writer.write("Incorrect input");
        }
        if (addressService.getById(id) != null) {
            addressService.deleteById(id);
        } else {
            writer.write("No one addresses have this id");
        }

    }

    @Override
    public void findAll() {
        List<Address> addresses = addressService.findAll();
        for (Address address : addresses) {
            writer.write(address.getId() + " " + address.getStreet());
        }
    }

    @Override
    public void findByStreet() {
        writer.write("Enter address name:");
        String address = reader.readString();
        if (addressValidator.isValidAddressName(address)) {
            if (!checkAddress(address)) {
                System.out.println(" street: "+ addressService.findByStreet(address).getStreet() + " id:" + addressService.findByStreet(address).getId());
            } else {
                writer.write("No one address has this name");
            }
        } else {
            writer.write("Incorrect input");
        }

    }

    private boolean checkAddress(String street) {
        return addressService.findByStreet(street) == null;
    }
}
