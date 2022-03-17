package com.company.repository;

import com.company.entity.Order;
import com.company.entity.User;

import java.util.List;

public interface OrderRepository {
    void add(Order order);
    void deleteById(int id);
    Order findById(int id);
    List<Order> findAll();
    List<Order>  findAllByUser(User user);
}
