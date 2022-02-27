package com.company.service;

import com.company.model.City;
import com.company.repository.CityRepository;
import com.company.repository.InMemoryCityRepository;

import java.util.List;

public class CityServiceImpl implements CityService{
    private CityRepository cityRepository;
    {
        cityRepository = new InMemoryCityRepository();
    }
    @Override
    public void add(City city) {
      cityRepository.add(city);
    }

    @Override
    public City getById(int id) {
        return cityRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
