package com.example.week2day4.services;

import com.example.week2day4.model.Car;
import com.example.week2day4.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private ArrayList<Car>cars=new ArrayList<Car>();
    private final UserService userService;
    private final LogService logService;
    public ArrayList<Car> getCars(){
   return cars;
    }
    public Car getCar(String id){
        for (int i = 0; i <cars.size() ; i++) {
            if(cars.get(i).getId().equals(id)){
                return cars.get(i);
            }
        }
        return null;
    }
    public boolean addCar(Car car){
        return cars.add(car);
    }

    public ArrayList<Car> getCarByType(String type) {
        ArrayList<Car>filtered_cars=new ArrayList<>();
        for (int i = 0; i <cars.size() ; i++) {
            if(cars.get(i).getCarType().equals(type)){
                filtered_cars.add(cars.get(i));
            }
        }
        return filtered_cars;
    }


    public Integer makePurchase(String carId, String userId) {
        User curr_user=userService.getUser(userId);



        Integer userBalance=curr_user.getBalance();
        ArrayList<Car>user_cars=curr_user.getOwned_cars();

        Car curr_car=getCar(carId);

        Integer carPrice=curr_car.getPrice();


        if(curr_user==null || curr_car==null){
            return  -1;
        }
        if(userBalance<carPrice){
            return 0;
        }
        if(curr_car.getStock().equals(0)){
            return 1;
        }
        curr_user.setBalance(userBalance-carPrice);
        user_cars.add(curr_car);
        curr_car.setStock(curr_car.getStock()-1);
        logService.addLog("user :"+curr_user.getId()+" has purchased the car :"+curr_car.getId());

        return 2;


    }

    public Boolean sellCar(String carId, String userId) {
        User curr_user=userService.getUser(userId);
        ArrayList<Car>user_cars=curr_user.getOwned_cars();
        Integer curr_userBalance=curr_user.getBalance();

        Car curr_car=getCar(carId);
        Integer carPrice=curr_car.getPrice();
        Integer curr_carStock=curr_car.getStock();


        if(curr_user==null||curr_car==null){
            return false;
        }
        for (int i = 0; i <user_cars.size(); i++) {
            if(user_cars.get(i).getId().equals(carId)){
                user_cars.remove(i);
            }
        }

        curr_user.setBalance(curr_userBalance+carPrice);
        curr_car.setStock(curr_carStock+1);

        logService.addLog("user :"+curr_user.getId()+" has sold the car :"+curr_car.getId());

        return true;
    }
}
