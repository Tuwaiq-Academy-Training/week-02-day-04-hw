package com.example.assignment8.service;

import com.example.assignment8.model.Car;
import com.example.assignment8.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {

    private ArrayList<Car> cars = new ArrayList<>();

    private final UserService userService;
    private final LogService logService;

    public ArrayList<Car> getCars() {

        return cars;
    }

    public boolean addCars(Car car){

        return cars.add(car);
    }

    public ArrayList<Car> getCarsByType(String type){
        ArrayList <Car> carsType = new ArrayList<>();
        for (Car car:cars) {
            if(car.getCarType().equals(type)){
                carsType.add(car);
            }
        }
        return carsType;
    }

    public Integer buyCar(String carId, String userid) {
        Car  currentCar  = getCar(carId);
        User currentUser = userService.getUser(userid);
        if(currentUser == null){
            return -1;
        }
        if(currentCar == null){
            return 0;
        }

        if(!(currentUser.getBalance() >= currentCar.getPrice())){
            return 1;
        }

        //cars.remove(currentCar);
        Integer newBalance = currentUser.getBalance() - currentCar.getPrice();
        currentUser.setBalance(newBalance);

        Integer newStock = currentCar.getStock() -1;
        currentCar.setStock(newStock);

        currentUser.getCarOwned().add(currentCar);

        logService.addLog("The user : " + currentUser.getId() + " Bought the car : " + currentCar.getId());
        return 2;

    }

    public Car getCar(String CarId){
        for (Car car:cars) {
            if(car.getId().equals(CarId)){
                return car;
            }
        }
        return null;
    }

    public Integer resellCar(String carId, String userid) {
        Car  currentCar  = getCar(carId);
        User currentUser = userService.getUser(userid);
        if(currentUser == null){
            return -1;
        }
        if(currentCar == null){
            return 0;
        }

        if(!(currentCar.getStock() > 0)){
            return 1;
        }

        Integer newStock = currentCar.getStock() + 1;
        currentCar.setStock(newStock);

        Integer newBalance = currentUser.getBalance() + currentCar.getPrice();
        currentUser.setBalance(newBalance);

        currentUser.getCarOwned().remove(currentCar);

        logService.addLog("The user : " + currentUser.getId() + " resell the car : " + currentCar.getId());
        return 2;

    }


}
