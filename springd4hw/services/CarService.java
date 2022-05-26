package com.example.springd4hw.services;

import com.example.springd4hw.model.Car;
import com.example.springd4hw.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {

   private final ArrayList<Car> cars = new ArrayList();
   private final UserService userService;


   public ArrayList<Car> getCars() {
      return cars;
   }

   public boolean addCars(Car car) {
      for (int i = 0; i < cars.size(); i++) {
         Car currentCar = cars.get(i);
         if (currentCar.getId().equals(car.getId())) {
            return false;
         }
      }
       cars.add(car);
      return true;
   }

   public ArrayList carsByType(String type) {
      ArrayList<Car> c=new ArrayList();
      for (int i = 0; i < cars.size(); i++) {
         if (cars.get(i).getCarType().equals(type)) {
            c.add(cars.get(i));
         }
      }
      if(c.size()==0){
         return null;
      }
      return c;
   }

   public Car getCar(String carid){
      for (Car car:cars) {
         if(car.getId().equals(carid)){
            return car;
         }
      }
      return null;
   }

   public Integer buyCar(String carid, String userid){
    Car currentCar = getCar(carid);
    User currentUser = userService.getUser(userid);

    if(currentUser==null){
       return -1;
    }
    if(currentCar==null){
       return 0;
    }
    if(currentUser.getBalance()<currentCar.getPrice()){
       return 1;
    }
    Integer oldStock = currentCar.getStock();
    currentCar.setStock(oldStock);
    Integer oldBalance = currentUser.getBalance();
    currentUser.setBalance(oldBalance- currentCar.getPrice());

    currentUser.getMyCar().add(currentCar);
    return 2;
   }


    public Integer sellaCar(String userid, String carid) {
        Car car=getCar(carid);
        User user=userService.getUser(userid);

        if(car==null || user ==null){
            return -1;
        }

        if(!user.getMyCar().contains(car)){
            return 0;
        }
        car.setStock(car.getStock()+1);
        user.setBalance(user.getBalance()+car.getPrice());
        user.getMyCar().remove(car);

        return 1;


    }
}
