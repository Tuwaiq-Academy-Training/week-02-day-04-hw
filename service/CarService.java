package com.example.cardealershipmanagementsystem.service;


import com.example.cardealershipmanagementsystem.models.Car;
import com.example.cardealershipmanagementsystem.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private ArrayList<Car> carList=new ArrayList<>();
    private final UserService userService;

    public ArrayList<Car> getCars(){
        return carList;
    }

    public boolean addCar(Car newCar){
        return carList.add(newCar);
    }

    public ArrayList<Car> getCarsByType(String type) {
        ArrayList <Car>carsType=new ArrayList<>();

        for (Car car: carList) {
            if(car.getCarType().equals(type)){
                carsType.add(car);
            }
        }

        return carsType;
    }

    public Integer purchaseCar(String userid, String carid) {
        Car car=getCar(carid);
        User user=userService.getUser(userid);

        if(car==null || user ==null){
            return -1;
        }

        if(user.getBalance()<car.getPrice()){
            return 0;
        }

        if(car.getStock()==0){
            return 1;
        }

        Integer oldStock=car.getStock();
        car.setStock(oldStock-1);

        Integer oldBalance=user.getBalance();
        user.setBalance(oldBalance-car.getPrice());

        user.getCarsOwneds().add(car);

        return 2;

    }

    public Integer sellaCar(String userid, String carid) {
        Car car=getCar(carid);
        User user=userService.getUser(userid);

        if(car==null || user ==null){
            return -1;
        }

        if(!user.getCarsOwneds().contains(car)){
            return 0;
        }
        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
        user.getCarsOwneds().remove(car);

        return 1;


    }

    public Car getCar(String cardid){
        for (Car car:carList) {
            if(car.getId().equals(cardid)){
                return car;
            }
        }
        return null;
    }
}





