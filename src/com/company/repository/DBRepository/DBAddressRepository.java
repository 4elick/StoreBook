package com.company.repository.DBRepository;

import com.company.entity.Address;
import com.company.repository.AddressRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAddressRepository extends DBAbstractRepository implements AddressRepository {
    private final String INSERT_ADDRESS = "INSERT INTO addresses VALUES(default,?)";
    private final String SELECT_BY_ID = "SELECT* FROM addresses WHERE address_id = ?";
    private final String DELETE_BY_ID = "DELETE FROM addresses WHERE address_id = ?";
    private final String SELECT_ALL = "SELECT* FROM addresses";
    private final String SELECT_BY_ADDRESS = "SELECT* FROM addresses WHERE address_name = ?";

    @Override
    public void add(Address address) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ADDRESS);
            statement.setString(1, address.getStreet());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Address getById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Address address = new Address(resultSet.getString(2));
            address.setId(id);
            statement.close();
            return address;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Address address = new Address(name);
                address.setId(id);
                addresses.add(address);
            }
            statement.close();
            return addresses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Address findByPlace(String place) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ADDRESS);
            statement.setString(1, place);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Address address = new Address(name);
            address.setId(id);
            return address;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
