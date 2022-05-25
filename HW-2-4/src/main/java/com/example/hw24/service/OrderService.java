package com.example.hw24.service;

import com.example.hw24.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OrderService {
    private ArrayList<Order> orders=new ArrayList();

    public ArrayList<Order> getOrder(){

        return  orders;
    }
    public boolean addOrder(Order order) {

        return orders.add(order);
    }
}
