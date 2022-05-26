package com.example.serviceprojectday04.services;

import com.example.serviceprojectday04.models.Car;
import com.example.serviceprojectday04.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor @Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars(){
        return cars;
    }
    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public List getCarsByType(){
        List carsByType = new ArrayList();
        for(Car car: cars){
            carsByType.add(carsByType);
        }
        return carsByType;
    }

}
