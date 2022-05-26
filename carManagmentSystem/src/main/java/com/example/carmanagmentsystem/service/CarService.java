package com.example.carmanagmentsystem.service;

import com.example.carmanagmentsystem.model.Car;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor

public class CarService {
    private ArrayList<Car>cars=new ArrayList<Car>();

    @NonNull
    private final LogService logService;
    public ArrayList<Car> getAllCars(){
        return cars;
    }

    public boolean addNewCars(Car car){
        System.out.println(car.getId());
        logService.addLog(car.getId()+ " car has been registered ");
        System.out.println(car.getId());
        return cars.add(car);
    }

    public ArrayList<Car> getCarsByType(String type) {
        ArrayList<Car> carByType=new ArrayList<>();
        for (int i = 0; i < cars.size() ; i++) {
            if (cars.get(i).getCarType().equals(type)){
                carByType.add(cars.get(i));
            }
        }
        if (carByType.size()==0){
            return null;
        }
        return carByType;
    }
}
