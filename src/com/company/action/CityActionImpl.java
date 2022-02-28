package com.company.action;

import com.company.model.City;
import com.company.service.CityService;
import com.company.service.CityServiceImpl;
import com.company.util.Reader;
import com.company.util.ReaderImpl;
import com.company.util.Writer;
import com.company.util.WriterImpl;
import com.company.validator.CityValidator;

import java.util.List;

public class CityActionImpl implements CityAction{
    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private CityValidator cityValidator = new CityValidator();
    private CityService cityService = new CityServiceImpl();

    @Override
    public void add() {
        writer.write("Enter name city: ");
        String cityName = reader.readString();
        if(!cityValidator.isValidCityName(cityName)){
            writer.write("Incorrect input");
            return;
        }
        if(!checkCity(cityName)){
            writer.write("This city has already been added!");
            return;
        }
        writer.write("Enter id:");
        int id = reader.readInt();
        if(cityValidator.isPositiveNumber(id)){
            if(checkCityId(id)){
                cityService.add(new City(cityName,id));
                findAll();
            }
            else {
                writer.write("City with this ID already exists");
            }
        }
        else {
            writer.write("Incorrect input");
        }

    }



    @Override
    public void getById() {
        writer.write("Enter id city: ");
        int id = reader.readInt();
        if(cityValidator.isPositiveNumber(id)){
            if(!checkCityId(id)){
                writer.writeCity(cityService.getById(id));
            }
            else {
                writer.write("There is no city with this id");
            }
        }
        else {
            writer.write("Incorrect input");
        }
    }

    @Override
    public void deleteById() {
        writer.write("Enter id city to delete it:");
        int id = reader.readInt();
        if(cityValidator.isPositiveNumber(id)){
            if(!checkCityId(id)){
                cityService.deleteById(id);
                findAll();
            }
            else {
                writer.write("There is no city with this id");
            }
        }
    }

    @Override
    public void findAll() {
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            writer.writeCity(city);
        }
    }
    private boolean checkCityId(int id) {
        if(cityService.getById(id)!= null){
            return  false;
        }
        else {
            return true;
        }
    }

    private boolean checkCity(String cityName){
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            if(city.getNameCity().equals(cityName)){
                return false;
            }
        }
        return true;
    }

}
