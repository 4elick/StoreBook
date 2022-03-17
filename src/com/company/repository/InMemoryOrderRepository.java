package com.company.repository;

import com.company.entity.Order;
import com.company.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository{
    private List<Order> orders;
    private int inc = 0;
    {
        orders = new ArrayList<>();
    }

    @Override
    public void add(Order order) {
        order.setId(++inc);
        orders.add(order);
    }

    @Override
    public void deleteById(int id) {
        for (Order order : orders) {
            if(order.getId() == id){
                orders.remove(order);
            }
        }
    }

    @Override
    public Order findById(int id) {
        for (Order order : orders) {
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public List<Order> findAllByUser(User user) {
        List<Order> temp = new ArrayList<>();
        for (Order order : orders) {
            if(order.getUser().equals(user)){
                temp.add(order);
            }
        }
        if(temp.isEmpty()){
            return null;
        } else {
            return temp;
        }
    }

}
