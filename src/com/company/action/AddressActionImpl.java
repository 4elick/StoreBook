package com.company.action;

import com.company.model.Address;
import com.company.model.City;
import com.company.service.AddressService;
import com.company.service.AddressServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.AddressValidator;
import com.company.validator.CityValidator;

import java.util.List;

public class AddressActionImpl implements AddressAction {
    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private AddressService addressService = new AddressServiceImpl();
    private AddressValidator addressValidator = new AddressValidator();
    private CityValidator cityValidator = new CityValidator();

    public AddressActionImpl(Writer writer, Reader reader, AddressService addressService, AddressValidator addressValidator) {
        this.writer = writer;
        this.reader = reader;
        this.addressService = addressService;
        this.addressValidator = addressValidator;
    }

    @Override
    public void add() {
        writer.write("Enter address");
        String address = reader.readString();
        if (!addressValidator.isValidAddressName(address)) {
            writer.write("Incorrect input");
            return;
        }
        writer.write("Enter city: ");
        String city = reader.readString();
        if (!cityValidator.isValidCityName(city)) {
            writer.write("Incorrect input");
            return;
        }
        if (checkAddress(address)) {
            addressService.add(new Address(address, new City(city)));
        } else {
            writer.write("This address has already been added");
        }

    }

    @Override
    public void getById() {
        writer.write("Enter id address: ");
        int id = reader.readInt();
        if (addressValidator.isPositiveNumber(id)) {
            writer.write("City: " + addressService.getById(id).getCity().getNameCity() + "address: " + addressService.getById(id).getPlace());
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
            writer.write("City: " + address.getCity().getNameCity() + "address: " + address.getPlace());
        }
    }

    private boolean checkAddress(String address) {
        return addressService.findByPlace(address) == null;
    }
}
