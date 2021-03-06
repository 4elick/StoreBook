package com.company.entity;

public class Store {
    private int id;
    private String name;
    private City city;
    private Address address;

    public Store(City city, Address address,String name) {
        this.city = city;
        this.address = address;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void  setName(String name){
        this.name = name;
    }

    public City getCity(){
        return city;
    }

    public void setCity(City city){
        this.city = city;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }
}
