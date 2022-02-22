package com.company.repository;


import com.company.model.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCityRepository implements CityRepository{
    List<City> cities;
    {cities = new ArrayList<>();}

    @Override
    public void add(City city) {
        cities.add(city);
    }

    @Override
    public City getById(int id) {
        try {
            return cities.get(id);
        }catch (IndexOutOfBoundsException e){
            System.out.println("You miss p4el");
            return null; /*уточнить насколько это работает*/
        }
    }

    @Override
    public void deleteById(int id) {
        cities.remove(id);
    }

    @Override
    public City[] findAll() {
        if(!cities.isEmpty()){
            return cities.toArray(new City[0]);

        }
        else {
            return new City[0];
        }
    }
}
