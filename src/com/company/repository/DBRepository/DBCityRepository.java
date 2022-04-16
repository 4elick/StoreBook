package com.company.repository.DBRepository;

import com.company.entity.City;
import com.company.repository.CityRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCityRepository extends DBAbstractRepository implements CityRepository {
    private final String INSERT_INTO_CITY = "INSERT INTO cities VALUES(default,?)";
    private final String SELECT_CITY_BY_ID = "SELECT* FROM cities WHERE city_id = ?";
    private final String SELECT_CITY_BY_NAME = "SELECT* FROM cities WHERE city_name = ?";
    private final String SELECT_ALL = "SELECT* FROM cities";
    private final String DELETE_CITY_BY_ID = "DELETE FROM cities WHERE city_id = ?";

    @Override
    public void add(City city) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CITY);
            statement.setString(1, city.getNameCity());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public City findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CITY_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString(2);
            City city = new City(name);
            city.setId(id);
            statement.close();
            return city;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CITY_BY_ID);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                City city = new City(name);
                city.setId(id);
                cities.add(city);

            }
            statement.close();
            return cities;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public City findByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CITY_BY_NAME);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            City city = new City(resultSet.getString(2));
            city.setId(resultSet.getInt(1));
            statement.close();
            return city;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
