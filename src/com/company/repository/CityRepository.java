package com.company.repository;


import com.company.model.City;

import java.util.List;

public interface CityRepository {
    void add(City city);
    City getById(int id);
    void deleteById(int id);
    List<City> findAll();
}
