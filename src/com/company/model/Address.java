package com.company.model;

public class Address {
    private String street;
    private int id;

    public Address(String street) {
        this.street = street;
    }
    public  String getStreet(){
        return street;
    }


    public int getId(){ return id;}
    public void setId(int id){
        this.id = id;
    }
}
