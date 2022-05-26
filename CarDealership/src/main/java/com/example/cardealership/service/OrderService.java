package com.example.cardealership.service;

import com.example.cardealership.model.Car;
import com.example.cardealership.model.Order;
import com.example.cardealership.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService {
    List<Order> orders = new ArrayList<>();
    private final CarService carService;
    private final UserService userService;


    public OrderService(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }
    public List<Order> getOrders(){
        return orders;
    }

    public void updateRide(Order order, Order o){
        order.setUserid(o.getUserid());
        order.setCarid(o.getCarid());
    }

    public boolean deleteOrder(String id){

        if (isOrderByID(id)){
            Order order = getById(id);
            getOrders().remove(order);
            return true;
        }
        return false;
    }

    public boolean isOrderByID(String id){
        int checkForWork = -1;
        Order order = getById(id);
        if (order != null){
            checkForWork = Integer.parseInt(id);
        }
        return (checkForWork == -1) ? false :  true;
    }


    public boolean addOrder(Order order){
        return orders.add(order);
    }
    public  Order getById(String id){
        for (Order order: this.orders) {
            if (order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public boolean purchaseCar(Order o) {
        User user = userService.getById(o.getUserid());
        Car car = carService.getById(o.getCarid());
        if (user == null || car == null ){
            return false;
        }
        if (user.getBalance()<=car.getPrice() || car.getStock() <=0){
            return false;
        }
        if (user.getCarsOwned() != null){
            user.getCarsOwned().add(car);
            car.setStock(car.getStock()-1);
            user.setBalance(user.getBalance()-car.getPrice());
            orders.add(o);
            return true;
        }
        ArrayList<Car> userCarsOwned = new ArrayList<>();
        userCarsOwned.add(car);
        user.setCarsOwned(userCarsOwned);
        car.setStock(car.getStock()-1);
        user.setBalance(user.getBalance()-car.getPrice());
        orders.add(o);
        return true;
    }
    public boolean resellCar(Order o) {
        User user = userService.getById(o.getUserid());
        Car car = carService.getById(o.getCarid());
        if (user == null || car == null ){
            return false;
        }

        if (user.getCarsOwned() != null && isCarOwned(user,car)){
            user.getCarsOwned().remove(car);
            car.setStock(car.getStock()+1);
            user.setBalance(user.getBalance()+car.getPrice());
            orders.add(o);
            return true;
        }

        return false;
    }

    public boolean isCarOwned(User user, Car car){
        for (Car c: user.getCarsOwned()) {
            if (c.getId().equals(car.getId())){
                return true;
            }
        }
        return false;
    }
}
