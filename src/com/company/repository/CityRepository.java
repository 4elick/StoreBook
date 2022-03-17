package com.company.repository;


import com.company.entity.City;

import java.util.List;

public interface CityRepository {
    void add(City city);
    City findById(int id);
    void deleteById(int id);
    List<City> findAll();
    City findByName(String name);
}
