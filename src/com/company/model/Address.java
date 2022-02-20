package com.company.model;

public class Address {
    private String address;
    private City city;

    public Address(String address,City city){
        this.address = address;
        this.city = city;
    }

    public  String getPlace(){
        return address;
    }

    public City getCity(){ return city;}

}
