package com.company.model;

public class Address {
    private String address;
    private City city;
    private int id;

    public Address(String address,City city) {
        this.address = address;
        this.city = city;
    }
    public  String getPlace(){
        return address;
    }

    public City getCity(){ return city;}
    public int getId(){ return id;}
    public void setId(int id){
        this.id = id;
    }
}
