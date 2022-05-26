package com.example.homework9.services;

import com.example.homework9.model.Car;
import com.example.homework9.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class CarServices {
    private ArrayList <Car> cars= new ArrayList<>();

    private final UserServices userService;
    private final LogsServices logsServices;
    public ArrayList<Car> getCars(){
        return  cars;
    }
    public boolean addCar(Car car) {return cars.add(car);}

    public ArrayList<Car> getCarby(String type1){
        ArrayList <Car> carbytype= new ArrayList<>();

        for (Car car:cars) {
            if(car.getCarType().equals(type1)){
                carbytype.add(car);}
        }
        return carbytype;}

    public Integer buyCar(String userid, String carid, Integer amount) {
        Users currentUser = userService.getUser(userid);
        Car currentcar = getCar(carid);
        if(currentUser==null){
            return -1;}
        if(currentcar==null){
            return 0;}

        if(!(amount >= currentcar.getPrice())){
            return 1;}
        if((amount > currentUser.getBalance())){
            return 2;}


            int numstock= currentcar.getStock();
            currentcar.setStock(numstock-1);

        currentUser.setBalance(currentUser.getBalance()-amount);
        currentUser.getCarsowned().add(currentcar);

       Integer logid = logsServices.getLogs().size();
       logsServices.addLog(logid,"The user : " +
                " "+currentUser.getId()+" Bought the car : "+ currentcar.getId());
        return 3;}

    public Integer resellCar(String userid, String carid){
        Users currentUser = userService.getUser(userid);
        Car currentcar=getCar(carid);
        if(currentUser==null){
            return -1;
        }
        if(currentcar==null){
            return 0;
        }

            int numstock= currentcar.getStock();
            currentcar.setStock(numstock+1);

        currentUser.setBalance(currentUser.getBalance()+currentcar.getPrice());
        currentUser.getCarsowned().remove(currentcar);
        Integer logid = logsServices.getLogs().size();
        logsServices.addLog(logid,"The user : " +
                " "+currentUser.getId()+" Resell the book : "+ currentcar.getId());
        return 1;
    }
    public Car getCar(String carid){
        for (Car car:cars) {
            if(car.getId().equals(carid)){
                return car;
            }
        }
        return null;
    }

}
