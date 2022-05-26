package com.example.cardealershipmanagemen.Service;

import com.example.cardealershipmanagemen.Models.Car;
import com.example.cardealershipmanagemen.Models.CarOwned;
import com.example.cardealershipmanagemen.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {

    public ArrayList<Car> cars = new ArrayList<>();
    public final UserService userService;
    public final LogService logService;



    public ArrayList<Car> getCar(){
        return cars;
    }

    public String addCar(Car car){
        cars.add(car);
        return "add car !!";
    }

    public String updateCar(int index, Car car){
        cars.set(index,car);
        return "update car";
    }
    public String deleteCar(int index){
        cars.remove(index);
        return "car deleted !!";
    }

    public ArrayList<Car> getCarType(String type) {
        ArrayList<Car> cars1 = new ArrayList<>();
        for (Car car: cars){
            if(car.getCarType().equals(type)){
                cars1.add(car);
            }
        }
        return cars1;
    }

    public int purchaseCar(String userID, String carID) {

        User user = userService.checkUser(userID);
        if (user == null){
            return -2;
        }
        Car car = checkCar(carID);
        if (car == null){
            return -1;
        }
        if (car.getStock() <= 0){
            return 0;
        }
        if (car.getPrice() > user.getBalance()){
            return 1;
        }
        if (user.getCarsOwned() == null){
            user.setBalance(user.getBalance()-car.getPrice());
            ArrayList<CarOwned> carOwneds = new ArrayList<>();
            carOwneds.add(new CarOwned(car.getId(),car.getModel(),car.getCarType(),car.getPrice()));
            user.setCarsOwned(carOwneds);
            car.setStock(car.getStock()-1);
            return 2;
        }
        user.setBalance(user.getBalance()-car.getPrice());
        ArrayList<CarOwned> carOwneds = new ArrayList<>();
        carOwneds.add(new CarOwned(car.getId(),car.getModel(),car.getCarType(),car.getPrice()));
        user.setCarsOwned(carOwneds);
        car.setStock(car.getStock()-1);
        logService.addLog(userID,carID);

        return 2;


    }

    public int sellaCar(String userID, String carID) {
        Car car=checkCar(carID);
        User user=userService.checkUser(userID);

        if(car==null || user ==null){
            return -1;
        }

        if(!user.getCarsOwned().contains(car)){
            return 0;
        }
        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
        user.getCarsOwned().remove(car);
        logService.addLog(userID,carID);
        return 1;


    }

    public Car checkCar(String carID){
        for (Car car: cars){
            if (car.getId().equals(carID)){
                return car;
            }
        }
        return null;
    }
}
