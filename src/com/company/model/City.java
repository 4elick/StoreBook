package com.company.model;

public class City {
    private String city;
    private int id;

    public City(String city){
        this.city = city;
    }
    public City(String city, int id){
        this.city = city;
        this.id = id;
    }
    public String getNameCity(){ return city; }
    public int getId(){ return id;}
    //public void setNameCity(String city){
    //     this.city = city;
    // }
}
