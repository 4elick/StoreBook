package com.company.entity;

public class City {
    private String city;
    private int id;

    public City(String city) {
        this.city = city;
    }

    public String getNameCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //public void setNameCity(String city){
    //     this.city = city;
    // }
}
