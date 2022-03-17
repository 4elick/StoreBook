package com.company.action;

import com.company.entity.Address;
import com.company.entity.Book;
import com.company.entity.Order;
import com.company.entity.Store;
import com.company.service.OrderService;
import com.company.service.StoreService;
import com.company.util.Reader;
import com.company.util.Writer;
import com.company.action.ConsoleApplicationImpl;

import java.util.Arrays;
import java.util.List;

import static com.company.action.ConsoleApplicationImpl.activateSession;

public class OrderActionImpl implements OrderAction{
    private Writer writer;
    private Reader reader;
    private OrderService orderService;
    private StoreService storeService;

    public OrderActionImpl(Writer writer, Reader reader, OrderService orderService, StoreService storeService) {
        this.writer = writer;
        this.reader = reader;
        this.orderService = orderService;
        this.storeService = storeService;
    }
    @Override
    public void getOrderHistory() {
        List<Order> orders = orderService.findAllByUser(activateSession.getUser());
        if(orders.isEmpty()){
            writer.write("You don't have orders");
        } else {
            for (Order order : orders) {
                if(order.getAddress() == null)
                writer.write(order.getId() + " " + order.getTotalPrice() + " " + Arrays.toString(order.getBooks().toArray()));
            }
        }

    }

    @Override
    public void addPickUp() {
        writer.write("Choose a pickup point:");
        List<Store> stores = storeService.findAll();
        for (Store store : stores) {
            if(store==null) break;
            writer.write(store.getId() +" "+ store.getName());
        }
        int id =reader.readInt();
        Store store = storeService.findById(id);
        Order order=new Order(activateSession.getBasket().getBooks(),store,activateSession.getUser());
        orderService.add(order);
        writer.write("Total price of order = " + order.getTotalPrice());
    }

    @Override
    public void addDelivery() {
        writer.write("Enter shipping address:");
        String address=reader.readString();
        Address address1=new Address(address);
        Order order=new Order(activateSession.getBasket().getBooks(),address1,activateSession.getUser());
        orderService.add(order);
        writer.write("Total price of order = " + order.getTotalPrice());

    }
}
