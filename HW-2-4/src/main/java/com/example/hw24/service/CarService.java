package com.example.hw24.service;

import com.example.hw24.model.Car;
import com.example.hw24.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private final UserService userService;
    private final LogService logService;

    private ArrayList<Car> carArrayList =new ArrayList();
    public ArrayList<Car> getCar(){

        return carArrayList;
    }
    public boolean addCar(Car car) {

        return carArrayList.add(car);
    }




    public ArrayList carType(String carrtype) {

        ArrayList<Car> cartype=new ArrayList<>();
        for (Car car: carArrayList) {
            if(car.getCartype().equals(carrtype)){
                cartype.add(car);
            }
        }
        return cartype;
    }

    public Car getCar(String carid){
        for (Car car: carArrayList) {
            if(car.getId().equals(carid)){
                return car;
            }
        }
        return null;
    }
    public Integer buyCar(String userid, String carid, Integer price) {
        User currentUser=userService.getUser(userid);
        Car currentCar=getCar(carid);
        if(currentUser==null){
            return -1;
        }
        if(currentCar==null){
            return 0;
        }

        if(!(price >= currentCar.getPrice())){
            return 1;
        }
        currentUser.setBalance(currentUser.getBalance()-currentCar.getPrice());
        currentCar.setStock(currentCar.getStock()-1);
     currentUser.getCarsowen().add(currentCar);


        logService.addLog("The user : " +" "+currentUser.getId()+" Bought the car : "+ currentCar.getId());

        return 2;

    }

    public  Integer resell(String userid, String carid) {
        User currentUser=userService.getUser(userid);
        Car currentCar=getCar(carid);
        if(currentUser==null){
            return -1;
        }
        if(currentCar==null){
            return 0;
        }
        currentUser.setBalance(currentUser.getBalance()+currentCar.getPrice());
        currentCar.setStock(currentCar.getStock()+1);
       carArrayList.remove(currentUser.getCarsowen());


        logService.addLog("The user : " +" "+currentUser.getId()+" sell the car : "+ currentCar.getId()+" the stock"+currentCar.getStock());

        return 1;

    }

}
