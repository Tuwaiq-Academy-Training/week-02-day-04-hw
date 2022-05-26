package com.example.assignment8.service;

import com.example.assignment8.controller.CarController;
import com.example.assignment8.model.Car;
import com.example.assignment8.model.Order;
import com.example.assignment8.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    private ArrayList<Order> orders = new ArrayList<>();
    private final UserService userService;
    private final CarService carService;
    private final LogService logService;

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public boolean addOrder(Order order){

        User currentUser = userService.getUser(order.getUserId());
        Car currentCar = carService.getCar(order.getCarId());
        if(currentUser == null || currentCar == null){
            return false;
        }
        logService.addLog("New order added by " + currentUser.getId() +" To a car " + currentCar.getId());
        return orders.add(order);
    }
}
