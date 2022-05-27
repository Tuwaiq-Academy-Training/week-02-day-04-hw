package com.example.car.Car;

import com.example.car.Logs.LogsService;
import com.example.car.User.User;
import com.example.car.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CarService {

    private ArrayList<Car> carList = new ArrayList<>();

    private final LogsService logsService;
    private final UserService userService;
    public ArrayList<Car> getCars(){
        return carList;
    }

    public boolean addCar(Car newCar){
        return carList.add(newCar);
    }




    public ArrayList<Car> getCarsByType(String type) {
    ArrayList<Car> carsType = new ArrayList();

        for(Car car: carList){
            if(car.getCarType().equals(type)){
                carsType.add(car);
            }
    }
return carsType;

    }

    public Integer purchaseCar(String  carid, String userid) {

    Car car = getCar(carid);
    User user = userService.getUser(userid);

        if (car == null || user == null){
            return -1;
        }
        if (user.getBalance() < car.getPrice() ){
            return 0;
        }
        if (car.getStock() == 0){
            return 1;

        }
        Integer oldStock = car.getStock();
        car.setStock(oldStock-1);
        Integer oldBalance = user.getBalance();
        user.setBalance(oldBalance-car.getPrice());

        user.getCarsOwned().add(car);

        return 2;


    }

    public Integer sellCar(String  carid, String userid) {

        Car car = getCar(carid);
        User user = userService.getUser(userid);

        if (car == null || user == null){
            return -1;
        }


        if (!user.getCarsOwned().contains(car)){
            return 0;
        }

        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
        user.getCarsOwned().remove(car);
        return 1;


    }
    //here
    public Car getCar(String carid){
        for (Car car:carList){
            if (car.getID().equals(carid)){
                return car;
            }
        }
        return null;
    }

}
