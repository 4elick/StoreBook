package com.company.action;

import com.company.entity.Address;
import com.company.entity.City;
import com.company.entity.Store;
import com.company.service.AddressService;
import com.company.service.CityService;
import com.company.service.StoreService;
import com.company.util.Reader;
import com.company.util.Writer;

import java.util.List;

public class StoreActionImpl implements StoreAction {
    private Writer writer;
    private Reader reader;
    private StoreService storeService;
    private CityService cityService;
    private AddressService addressService;

    public StoreActionImpl(Writer writer, Reader reader, StoreService storeService, CityService cityService, AddressService addressService) {
        this.writer = writer;
        this.reader = reader;
        this.storeService = storeService;
        this.cityService = cityService;
        this.addressService = addressService;
    }

    @Override
    public void add() {
        City city;
        Address address;
        city = selectCity();
        address = selectAddress();
        writer.write("Enter store name: ");
        String name = reader.readString();
        if(storeService.findByName(name)==null){
            storeService.add(new Store(city, address, name));
        } else {
            writer.write("This store has already been added");
        }


    }

    @Override
    public void deleteById() {
        writer.write("Enter id to delete store:");
        int id = reader.readInt();
        if(storeService.findById(id) != null){
            storeService.deleteById(id);
        } else {
            writer.write("No one store has this id");
        }
    }

    @Override
    public void findByName() {
        writer.write("Enter store name:");
        String name = reader.readString();
        if(storeService.findByName(name)!= null){
            Store store = storeService.findByName(name);
            writer.write(store.getId() + " " + store.getCity().getNameCity() + " " + store.getAddress().getStreet() +
                    " " + store.getName());
        } else {
            writer.write("No one Store has this name!");
        }

    }

    @Override
    public void findById() {
        writer.write("Enter store id");
        int id = reader.readInt();
        if(storeService.findById(id)!= null){
            Store store = storeService.findById(id);
            writer.write(store.getId() + " " + store.getCity().getNameCity() + " " + store.getAddress().getStreet() +
                    " " + store.getName());
        } else {
            writer.write("No one Store has this id!");
        }

    }

    @Override
    public void findAll() {
        List<Store> stores = storeService.findAll();
        for (Store store : stores) {
            writer.write(store.getId() + " " + store.getCity().getNameCity() + " " + store.getAddress().getStreet() +
                    " " + store.getName());
        }
    }

    private City selectCity() {
        writer.write("Select city  to add the store");
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            System.out.println(city.getNameCity());
        }
        String cityName = reader.readString();
        if (cityService.findByName(cityName) != null) {
            return cityService.findByName(cityName);
        } else {
            writer.write("No one city has this name");
            return null;
        }
    }

    private Address selectAddress() {
        writer.write("Select address to add the store");
        List<Address> addresses =  addressService.findAll();
        for (Address address : addresses) {
            System.out.println(address.getStreet());
        }
        String address = reader.readString();
        if (addressService.findByStreet(address) != null) {
            return addressService.findByStreet(address);
        } else {
            writer.write("No one address has this street");
            return null;
        }
    }
}
