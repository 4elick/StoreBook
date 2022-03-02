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

public class CityActionImpl implements CityAction {
    private Writer writer = new WriterImpl();
    private Reader reader = new ReaderImpl();
    private CityValidator cityValidator = new CityValidator();
    private CityService cityService = new CityServiceImpl();

    public CityActionImpl(Writer writer, Reader reader, CityValidator cityValidator, CityService cityService) {
        this.writer = writer;
        this.reader = reader;
        this.cityValidator = cityValidator;
        this.cityService = cityService;
    }

    @Override
    public void add() {
        writer.write("Enter name city: ");
        String cityName = reader.readString();
        if (!cityValidator.isValidCityName(cityName)) {
            writer.write("Incorrect input");
            return;
        }
        if (!checkCity(cityName)) {
            writer.write("This city has already been added!");
            return;
        } else {
            cityService.add(new City(cityName));
        }

    }


    @Override
    public void getById() {
        writer.write("Enter id city: ");
        int id = reader.readInt();
        if (cityValidator.isPositiveNumber(id)) {
            if (cityService.getById(id)!= null) {
                writer.write("Name city :" + cityService.getById(id).getNameCity() + "City id" + cityService.getById(id).getId());
            } else {
                writer.write("There is no city with this id");
            }
        } else {
            writer.write("Incorrect input");
        }
    }

    @Override
    public void deleteById() {
        writer.write("Enter id city to delete it:");
        int id = reader.readInt();
        if (cityValidator.isPositiveNumber(id)) {
            if (cityService.getById(id) != null) {
                cityService.deleteById(id);
                findAll();
            } else {
                writer.write("There is no city with this id");
            }

        }
    }

    @Override
    public void findAll() {
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            writer.write("Name city :" + city.getNameCity() + "City id" + city.getId());
        }
    }


    private boolean checkCity(String cityName) {
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            if (city.getNameCity().equals(cityName)) {
                return false;
            }
        }
        return true;
    }

}
