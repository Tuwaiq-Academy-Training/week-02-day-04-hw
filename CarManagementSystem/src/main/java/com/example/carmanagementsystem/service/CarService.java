package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private ArrayList<Car> cars = new ArrayList<>();
    private final UserService userService;

    public ArrayList<Car> getCars(){
        return cars;
    }

    public boolean addCar(Car car ) {
        return cars.add(car);
    }

    public ArrayList<Car> getCarsByType(String carType) {
        ArrayList<Car> carsByType = new ArrayList<>();
        for(Car car : cars) {
            if (car.getCarType().equals(carType)) {
                carsByType.add(car);
            }
        }
        return carsByType;
    }

    public Car checkIfCarExists(String carid) {
        for(Car car : cars) {
            if (car.getCarID().equals(carid)) {
                return car;
            }
        }
        return null;
    }

    public Integer purchaseCar(String carid, String userid) {
        Car car = checkIfCarExists(carid);
        if (car == null) {
            return -1;
        }
        User user = userService.checkIfUserExist(userid);
        if (user == null) {
            return 0;
        }
        if(car.getStock() <= 0) {
            return 1;
        }

        if(user.getBalance() < car.getPrice()) {
            return 2;
        }
        user.setBalance(user.getBalance() - car.getPrice());
        car.setStock(car.getStock() - 1);
        user.addNewCar(car);
        return 3;
    }

    public Integer resellCar(String carid, String userid) {
        Car car = checkIfCarExists(carid);
        if (car == null) {
            return -1;
        }
        User user = userService.checkIfUserExist(userid);
        if (user == null) {
            return 0;
        }
        car.setStock(car.getStock() + 1);
        user.setBalance(user.getBalance() + car.getPrice());
        user.removeCar(car);
        return 1;

    }
}
