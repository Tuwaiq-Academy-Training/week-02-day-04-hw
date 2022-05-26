package com.example.CarSystem.services;

import com.example.CarSystem.models.Car;
import com.example.CarSystem.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderServices {

    private ArrayList<Order> orders = new ArrayList();

    public final OrderServices orderServices;

    public ArrayList getOrders(){
        return orders;
    }

}
