package com.company.service;

import com.company.entity.Order;
import com.company.entity.User;

import java.util.List;

public interface OrderService {
    void add(Order order);
    void deleteById(int id);
    Order findById(int id);
    List<Order> findAll();
    List<Order> findAllByUser(User user);
}
