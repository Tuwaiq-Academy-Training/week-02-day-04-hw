package com.example.cardealershipmanagementsystem.service;

import com.example.cardealershipmanagementsystem.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrder(){
        return orders;
    }


    public boolean addOrder(Order order) {
        return orders.add(order);
    }
}
