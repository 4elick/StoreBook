package com.company.service;

import com.company.model.City;

public interface CityService {
    void add(City city);
    City getById(int id);
    void deleteById(int id);
    City[] findAll();
}
