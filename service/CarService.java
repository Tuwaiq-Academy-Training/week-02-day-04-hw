package com.example.carmanagment.service;

import com.example.carmanagment.model.Car;
import com.example.carmanagment.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CarService {
   private ArrayList<Car> cars = new ArrayList<>();
   private final UserService userService;
  public ArrayList<Car> getCars(){
      return cars;
  }

    public ArrayList<Car> getCarsByType(String type) {
       ArrayList <Car>carsType=new ArrayList<>();
        for (Car car:cars) {
            if (car.getCarType().equals(type)){
                carsType.add(car);
            }
        }
        return carsType;
    }


    public boolean addCar(Car car) {
      return cars.add(car);
    }

    public Integer purchasedCar(String userid, String carid) {
      Car car = getCar(carid);
        User user =userService.getUsers(userid);
        if (car==null || user==null){
            return -1;
        }
        if (user.getBalance()<car.getPrice()){
            return 0;
        }
        if (car.getStock()==0){
            return 1;
        }
        Integer oldStock=car.getStock();
        car.setStock(oldStock-1);

        Integer oldBalance=user.getBalance();
        user.setBalance(oldBalance-car.getPrice());

        user.getCarOwned().add(car);
        return 2;
    }

    public Integer sellaCar(String userid, String carid) {
        Car car = getCar(carid);
        User user =userService.getUsers(userid);
        if (car==null || user==null){
            return -1;
        }
        if (!user.getCarOwned().contains(car)){
            return 0;
        }
        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
       user.getCarOwned().remove(car);
        return 1;
    }
    public Car getCar(String carid){
        for (Car car:cars) {
            if (car.getId().equals(carid)){
                return car;
            }
        }
        return null;
    }
}
