package com.example.cardealershipproj.services;


import com.example.cardealershipproj.models.Api;
import com.example.cardealershipproj.models.Car;
import com.example.cardealershipproj.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarServices {


    private final UserServices userServices;
    private final CarServices carServices;
    private final LogsServices logsServices;
    private ArrayList<Car> cars = new ArrayList<>();

    //return the cars list
    public ArrayList<Car> getCars() {
        return cars;

    }

    public Boolean addCar(Car car) {
        return cars.add(car);
    }


    public ArrayList<Car> getCarsByType(String type) {
        // making an empty list to save certain car types
        ArrayList<Car> carType = new ArrayList<>();
         // search for car list to get match
        for (Car car : cars){
            if(car.getCarType().equals(type)){
                carType.add(car);
            }
        }
           return carType;
    }


    public Integer buyCar(String carId, String userId) {
        Car car = getCar(carId);
        User user = userServices.getUser(userId); // here used userService to access user id
        if(car == null || user == null){
            return -1;
        }

        if(user.getBalance()<car.getPrice()){
            return 0;
        }
        if(car.getStock() == 0){
            return 1;
        }

        // reduce stock by 1 ( two methods)

        //one
        Integer oldStock = car.getStock();
        car.setStock(oldStock-1);
//        //two
//        car.setStock(car.getStock()-1);

        // now for balance - car price
//        Integer oldBalance = user.getBalance();
//        user.setBalance(oldBalance-car.getPrice());

        user.setBalance(user.getBalance() - car.getPrice());

        // add car to car owned list
        user.getCarOwned().add(car);
        return 2;

    }
   // selling a car
    public Integer sellCar(String userId , String carId){
        Car car = getCar(carId);
        User user = userServices.getUser(userId);

        if(car == null || user==null){
            return -1;
        }

        // check if the user own the car
        if(!user.getCarOwned().contains(car)){
            return 0;
        }

        // add to stock after selling a car
        car.setStock(car.getStock() + 1);
        user.setBalance(user.getBalance()+car.getPrice());// here a adding to current balance and car price


        return 1;
    }



// helper funct.
    public Car getCar(String cardid){
        for (Car car:cars) {
            if(car.getId().equals(cardid)){
                return car;
            }
        }
        return null;
    }








}
