package com.company.repository;


import com.company.model.City;

public interface CityRepository {
    void add(City city);
    City getById(int id);
    void deleteById(int id);
    City[] findAll();
}
