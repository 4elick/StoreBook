package com.company.repository.DBRepository;

import com.company.entity.Book;
import com.company.entity.Order;
import com.company.entity.User;
import com.company.repository.OrderRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBOrderRepository extends DBAbstractRepository implements OrderRepository {

    private final String INSERT_ORDER_INTO = "INSERT INTO orders VALUES(default,?,?,?,?) returning order_id";
    private final String INSERT_BOOKS_ORDER_INTO = "INSERT INTO books_order(?,?)";

    @Override
    public void add(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ORDER_INTO);
            if(order.getAddress() == null){
                statement.setInt(1,order.getStore().getId());
                statement.setNull(2,0);
            }


            statement.setInt(3,order.getUser().getId());
            statement.setDate(4,new Date(order.getDate().getTime()));
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int order_id = resultSet.getInt(1);
            statement.close();

            for (Book book : order.getBooks()) {
                PreparedStatement statement1 = connection.prepareStatement(INSERT_BOOKS_ORDER_INTO);
                statement1.setInt(1,order_id);
                statement1.setInt(2,book.getId());
                statement1.execute();
                statement1.close();
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findAllByUser(User user) {
        return null;
    }
}
