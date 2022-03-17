package com.company.service;

import com.company.entity.City;

import java.util.List;

public interface CityService {
    void add(City city);
    City getById(int id);
    void deleteById(int id);
    List<City> findAll();
    City findByName(String name);
}
