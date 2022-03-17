package com.company.repository;


import com.company.entity.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCityRepository implements CityRepository{
    private List<City> cities;
    private int inc = 0;
    {cities = new ArrayList<>();}

    @Override
    public void add(City city) {
        city.setId(++inc);
        cities.add(city);
    }

    @Override
    public City findById(int id) {
        for (City city : cities) {
            if(city.getId() == id) {
                return city;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (City city : cities) {
            if(city.getId() == id){
                cities.remove(city);
            }
        }
    }

    @Override
    public List<City> findAll() {
        return cities;
    }

    @Override
    public City findByName(String name) {
        for (City city : cities) {
            if(city.getNameCity().equals(name)) {
                return city;
            }
        }
        return null;
    }
}
