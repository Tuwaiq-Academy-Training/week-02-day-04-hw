package com.example.cardealership.Services;

import com.example.cardealership.Models.Car;
import com.example.cardealership.Models.Order;
import com.example.cardealership.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CarService carService;
    private final UserService userService;

    ArrayList<Order> orders=new ArrayList<>();

    public Boolean isAdd(Order order){
        Car car= carService.getCarByid(order.getCarid());
        User user=userService.getUserByid(order.getUserid());
        if (user==null || car==null)
            return false;
        orders.add(order);
        return true;
    }

    public ArrayList<Order> getOrders(){
        return  orders;
    }
}
