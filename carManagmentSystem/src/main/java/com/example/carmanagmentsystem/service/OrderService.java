package com.example.carmanagmentsystem.service;

import com.example.carmanagmentsystem.model.Car;
import com.example.carmanagmentsystem.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserService userService;

    private final CarService carService;

    private final LogService logService;

    public boolean purchaseCar(String carId , String userId){

        User currentUser=userService.getUsers().get(getUser(userId));
        Car currentCar=carService.getAllCars().get(getCar(carId));

        if(currentUser==null || currentCar==null || currentUser.getBalance()<currentCar.getPrice())
        { return false; }

        currentUser.setBalance(currentUser.getBalance()-currentCar.getPrice());
        currentUser.getUserCars().add(currentCar);
        currentCar.setStock(currentCar.getStock()-1);
        
        logService.addLog(currentUser.getId()+ " has been purchase "+currentCar.getId());
        return true;
    }

    public boolean reSellCar(String carId , String userId){

        User currentUser=userService.getUsers().get(getUser(userId));
        Car currentCar=carService.getAllCars().get(getCar(carId));

        if(currentUser==null || currentCar==null){ return false; }

        for (int i = 0; i < currentUser.getUserCars().size(); i++) {
            if (currentUser.getUserCars().get(i).equals(currentCar)){
                currentUser.setBalance(currentUser.getBalance()+currentCar.getPrice());
                currentUser.getUserCars().remove(currentCar);
                currentCar.setStock(currentCar.getStock()+1);
                logService.addLog(currentUser.getId()+ " has been re-sell "+currentCar.getId());
                return true;
            }
        }
        return false;

    }

    public Integer getUser(String userId){
        for (int i = 0; i < userService.getUsers().size(); i++) {
            if (userService.getUsers().get(i).getId().equals(userId)){
                return i;
            }
        }
        return null;
    }

    public Integer getCar(String carId){

        for (int i = 0; i < userService.getUsers().size(); i++) {
            if (carService.getAllCars().get(i).getId().equals(carId)){
                return i;
            }
        }
        return null;
    }
}
