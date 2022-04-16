package com.company.service;

import com.company.entity.City;
import com.company.repository.CityRepository;
import com.company.repository.DBRepository.DBCityRepository;
import com.company.repository.InMemoryCityRepository;

import java.util.List;

public class CityServiceImpl implements CityService{
    private DBCityRepository cityRepository;
    {
        cityRepository = new DBCityRepository();
    }
    @Override
    public void add(City city) {
      cityRepository.add(city);
    }

    @Override
    public City getById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }
}
