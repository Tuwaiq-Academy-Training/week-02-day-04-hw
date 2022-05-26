package com.example.homework.service;

import com.example.homework.model.Car;
import com.example.homework.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private ArrayList<Car> cars=new ArrayList<>();
    private final UserService userService;

    public ArrayList<Car> getCars(){
        return  cars;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public ArrayList<Car> getCarByType(String type){
        ArrayList<Car> carsType=new ArrayList<>();
        for (Car car:cars){
            if (car.getCarType().equals(type)){
                carsType.add(car);
            }
        }
        return carsType;
    }

    public Integer purchaseCar(String userid,String carid) {
        Car car = getCars(carid);
        User user = userService.getUser(userid);

        if (car == null || user == null) {
            return -1;
        }

        if (!user.getCarsOwned().contains(car)) {
            return 0;
        }
        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
        user.getCarsOwned().remove(car);
        return 1;
    }

    private Car getCars(String carid) {
        for (Car car:cars){
            if (car.getId().equals(carid)){
                return car;
            }
        }
        return null;
    }



}
