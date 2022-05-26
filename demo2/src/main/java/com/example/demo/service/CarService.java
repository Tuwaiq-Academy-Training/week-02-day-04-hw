package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.CarType;
import com.example.demo.model.CarsOwned;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
     ArrayList<Car> cars = new ArrayList<>();
     private final UserService userService;
     private final LogService logService;
    public ArrayList<Car> getCars(){
        return cars;
    }
    public boolean addCar(Car car){
        return cars.add(car);
    }
    public ArrayList<Car> listCarByType(CarType carType){
        ArrayList<Car> carTypes = new ArrayList<>();
        for(Car car : cars){
            if(carType.getCarType().equals(car.getCarType()))
                carTypes.add(car);
                return carTypes;
        }
        return null;

    }
    public Integer buyCar(String carID,String userID){
        Car currentCar = findCarById(carID);
        User currentUser = userService.findUserById(userID);
        if(currentCar == null){
            return -1;//car not found
        }
        if(currentUser == null){
            return 0;//user not found
        }
        if(currentCar.getPrice() > currentUser.getBalance()){
            return 1;//Balance isn't enough to make this purchase
        }
        if(currentUser.getCarsOwned() == null) {
            ArrayList<Car> newCar = new ArrayList<>();
            currentCar.setStock(currentCar.getStock() - 1);
            currentUser.setBalance(currentUser.getBalance() - currentCar.getPrice());
            ArrayList<CarsOwned> addNewCar = new ArrayList<>();
            addNewCar.add(new CarsOwned(currentCar.getId(), currentCar.getCarType(), currentCar.getPrice(), currentCar.getModel()));
            currentUser.setCarsOwned(addNewCar);
            logService.addLog(currentUser.getId()+" bought "+currentCar.getId()+" for "+currentCar.getPrice()+"SAR");

            return 2;//Car sold
        }
        currentCar.setStock(currentCar.getStock() - 1);
        currentUser.setBalance(currentUser.getBalance() - currentCar.getPrice());
        ArrayList<CarsOwned> addNewCar = new ArrayList<>();
        addNewCar.add(new CarsOwned(currentCar.getId(), currentCar.getCarType(), currentCar.getPrice(), currentCar.getModel()));
        currentUser.setCarsOwned(addNewCar);
        logService.addLog(currentUser.getId()+" bought "+currentCar.getId()+" for "+currentCar.getPrice()+"SAR");
        return 2;

    }
    public Car findCarById(String carID){
        for (Car car:cars) {
            if(car.getId().equals(carID)){
                return car;
            }
        }
        return null;
    }
    public Integer sellCar(String carID,String userID){
        Car currentCar = findCarById(carID);
        User currentUser = userService.findUserById(userID);
        if(currentCar == null){
            return -1;//car not found
        }
        if(currentUser == null){
            return 0;//user not found
        }
        if(currentCar.getPrice() > currentUser.getBalance()){
            return 1;//Balance isn't enough to make this purchase
        }
        if(currentUser.getCarsOwned() == null) {
            ArrayList<Car> newCar = new ArrayList<>();
            currentCar.setStock(currentCar.getStock() + 1);
            currentUser.setBalance(currentUser.getBalance() + currentCar.getPrice());
            ArrayList<CarsOwned> addNewCar = new ArrayList<>();
            addNewCar.remove(new CarsOwned(currentCar.getId(), currentCar.getCarType(), currentCar.getPrice(), currentCar.getModel()));
            currentUser.setCarsOwned(addNewCar);
            logService.addLog(currentUser.getId()+" sold "+currentCar.getId()+" back for "+currentCar.getPrice()+"SAR");

            return 2;//Car sold
        }
        currentCar.setStock(currentCar.getStock() + 1);
        currentUser.setBalance(currentUser.getBalance() + currentCar.getPrice());
        ArrayList<CarsOwned> addNewCar = new ArrayList<>();
        addNewCar.remove(new CarsOwned(currentCar.getId(), currentCar.getCarType(), currentCar.getPrice(), currentCar.getModel()));
        currentUser.setCarsOwned(addNewCar);
        logService.addLog(currentUser.getId()+" sold "+currentCar.getId()+" back for "+currentCar.getPrice()+"SAR");
        return 2;

    }
    }

