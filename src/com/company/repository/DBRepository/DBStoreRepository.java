package com.company.repository.DBRepository;

import com.company.entity.Address;
import com.company.entity.City;
import com.company.entity.Store;
import com.company.repository.StoreRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBStoreRepository extends DBAbstractRepository implements StoreRepository {
    private final String INSERT_INTO_STORE = "INSERT INTO stores VALUES(default,?,?,?)";
    private final String DELETE_STORE_BY_ID = "DELETE FROM stores WHERE store_id = ?";
    private final String SELECT_STORE_BY_NAME = "SELECT store_id,city_name,store_city_id,address_name,address_id,store_name FROM stores s " +
            "JOIN cities c ON s.store_city_id = c.city_id " +
            "JOIN addresses a ON s.store_address_id = a.address_id " +
            " WHERE store_name = ?";
    private final String SELECT_STORE_BY_ID = "SELECT store_id,city_name,store_city_id,address_name,address_id,store_name FROM stores s " +
            "JOIN cities c ON s.store_city_id = c.city_id " +
            "JOIN addresses a ON s.store_address_id = a.address_id " +
            "WHERE store_id = ?";
    private final String SELECT_ALL = "SELECT store_id,city_name,store_city_id,address_name,address_id,store_name FROM stores s " +
            "JOIN cities c ON s.store_city_id = c.city_id " +
            "JOIN addresses a ON s.store_address_id = a.address_id";

    @Override
    public void add(Store store) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_STORE);
            statement.setInt(1,store.getCity().getId());
            statement.setInt(2,store.getAddress().getId());
            statement.setString(3,store.getName());
            statement.execute();
            statement.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try{
            PreparedStatement statement = connection.prepareStatement(DELETE_STORE_BY_ID);
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public Store findByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_STORE_BY_NAME);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            City city = new City(resultSet.getString(2));
            city.setId(resultSet.getInt(3));
            Address address = new Address(resultSet.getString(4));
            address.setId(resultSet.getInt(5));
            Store store =new Store(city,address,resultSet.getString(6));
            store.setId(resultSet.getInt(1));
            statement.close();
            return store;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Store findById(int id) {
        try {
            PreparedStatement statement =connection.prepareStatement(SELECT_STORE_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            City city = new City(resultSet.getString(2));
            city.setId(resultSet.getInt(3));
            Address address = new Address(resultSet.getString(4));
            address.setId(resultSet.getInt(5));
            Store store =new Store(city,address,resultSet.getString(6));
            store.setId(resultSet.getInt(1));
            statement.close();
            return store;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Store> findAll() {
        List<Store> stores = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                City city = new City(resultSet.getString(2));
                city.setId(resultSet.getInt(3));
                Address address = new Address(resultSet.getString(4));
                address.setId(resultSet.getInt(5));
                Store store =new Store(city,address,resultSet.getString(6));
                store.setId(resultSet.getInt(1));
                stores.add(store);
            }
            statement.close();
            return stores;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
