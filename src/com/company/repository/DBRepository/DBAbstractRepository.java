package com.company.repository.DBRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAbstractRepository {
    Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/StoreBook";
    private final String USER = "postgres";
    private final String PASSWORD = "knigamenya";

    {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
