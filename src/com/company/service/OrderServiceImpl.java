package com.company.service;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.repository.InMemoryOrderRepository;
import com.company.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    {
        orderRepository = new InMemoryOrderRepository();
    }
    @Override
    public void add(Order order) {
        orderRepository.add(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order>  findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }
}
