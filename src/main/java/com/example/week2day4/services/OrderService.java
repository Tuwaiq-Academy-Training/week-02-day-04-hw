package com.example.week2day4.services;

import com.example.week2day4.model.Car;
import com.example.week2day4.model.Order;
import com.example.week2day4.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {
    private ArrayList<Order> orders=new ArrayList<>();
    private final CarService carService;
    private final UserService userService;
    private final LogService logService;

    public ArrayList<Order> getOrders(){
        return orders;
    }
    public boolean addOrder(Order order){
    User curr_user=userService.getUser(order.getUserid());
    Car curr_car=carService.getCar(order.getCarid());
    if(curr_user==null || curr_car==null){
        return false;
    }
    orders.add(order);
    logService.addLog("Order placed by user : "+curr_user.getId()+"of car : "+curr_car.getId());
    return true;
    }
}
