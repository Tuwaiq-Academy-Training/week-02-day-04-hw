package com.example.serviceprojectday04.services;

import com.example.serviceprojectday04.models.Car;
import com.example.serviceprojectday04.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class UserService {
    private List<User> users = new ArrayList<>();
    private final CarService carService;
    public List getUsers() {
        return users;
    }
    public boolean addUser(User user) {
        return users.add(user);
    }
    public Integer purchaseCar(String userid, String carId){
        User u =getUser(userid);
        Car c = getCar(carId);
            if( u != null){
                if(c != null){
                    if(u.getBalance() >= c.getPrice()){
                        u.setBalance(u.getBalance()-c.getPrice());
                        u.getCarsOwned().add(c);
                        c.setStock(c.getStock()-1);
                        return 0; //Successfully purchased
                    }
                    return 2; //No enough funds
                }
                return -1; //Car id is wrong
            }
            return 1; //user id is wrong
    }
    public Integer resellCar(String userid, String carId){
        User u =getUser(userid);
        Car c = getCar(carId);
        if( u != null){
            if(c != null){
                for(Car car: u.getCarsOwned()){
                    if(car.getId().equals(carId)){
                        u.setBalance(u.getBalance()+c.getPrice());
                        u.getCarsOwned().remove(c);
                        c.setStock(c.getStock()+1);
                        return 0; //Successfully Sold
                    }
                    return 2; //You don't own that car
                }
            }
            return -1; //Car id is wrong
        }
        return 1; //user id is wrong
    }
    public User getUser(String userid) {
        for (User user:users) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }
    public Car getCar(String carid) {
        for (Car car: carService.getCars()) {
            if(car.getId().equals(carid)){
                return car;
            }
        }
        return null;
    }
}
