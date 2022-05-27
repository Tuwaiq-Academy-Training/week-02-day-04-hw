package com.example.cardealership.Services;

import com.example.cardealership.Models.Car;
import com.example.cardealership.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {

    private final UserService userService;
    private ArrayList<Car> cars = new ArrayList<>();

    public boolean isAdd(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarid().equals(car.getCarid()))
                return false;
        }
        cars.add(car);
        return true;
    }


    public ArrayList<Car> getCar() {
        return cars;
    }


    public ArrayList<Car> Type(String type) {
         ArrayList<Car> cari = new ArrayList<>();

        for (Car car : cars) {
            if (car.getType().equals(type) )
                cari.add(car);
        }
        return cari;
    }


    public Car getCarByid(String carid) {
        for (Car car:cars ) {
            if (carid.equals(car.getCarid()))
                return car;
        }
        return null;
    }

    public Car purchase(String carid,String userid){
        Car car= getCarByid(carid);
        User user=userService.getUserByid(userid);

        if (user!=null||car!=null){
            if (user.getBalance()>=car.getPrice()){
                car.setStock(car.getStock()-1);
                user.setBalance(car.getPrice()-user.getBalance());
                user.getCarsowned().add(car);
            }
        }
    return car;

    }

    public Car resell(String carid,String userid){
        Car car= getCarByid(carid);
        User user=userService.getUserByid(userid);

        if (user!=null||car!=null){
            car.setStock(car.getStock()+1);
            user.setBalance(car.getPrice()+user.getBalance());
            user.getCarsowned().remove(car);
        }
        return car;
    }

}