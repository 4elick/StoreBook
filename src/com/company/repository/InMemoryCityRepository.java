package com.company.repository;


import com.company.model.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCityRepository implements CityRepository{
    private List<City> cities;
    private int inc = 0;
    {cities = new ArrayList<>();}

    @Override
    public void add(City city) {
        city.setId(inc++);
        cities.add(city);
    }

    @Override
    public City getById(int id) {
        for (City city : cities) {
            if(city.getId() == id) {
                return city;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        cities.remove(id);
    }

    @Override
    public List<City> findAll() {
        return cities;
    }
}
