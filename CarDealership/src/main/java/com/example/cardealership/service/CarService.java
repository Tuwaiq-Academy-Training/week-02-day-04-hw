package com.example.cardealership.service;

import com.example.cardealership.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CarService {
    List<Car> cars = new ArrayList<>();

    public CarService() {
        this.cars.addAll(
                List.of(
                        new Car("101","Suv", 1200,"camry",12),
                        new Car("102","Ahmed", 1300,"halix",13),
                        new Car("103","Salah", 1400,"gums",14),
                        new Car("104","Ali", 1500,"fast",15)
                ));
    }
    public List<Car> getCars(){
        return cars;
    }

    public void updateRide(Car car, Car c){
        car.setPrice(c.getPrice());
    }

    public boolean deleteCar(String id){

        if (isCarByID(id)){
            Car car = getById(id);
            getCars().remove(car);
            return true;
        }
        return false;
    }

    public boolean isCarByID(String id){
        int checkForWork = -1;
        Car car = getById(id);
        if (car != null){
            checkForWork = Integer.parseInt(id);
        }
        return (checkForWork == -1) ? false :  true;
    }

    public boolean addCar(Car car){
        return cars.add(car);
    }
    public  Car getById(String id){
        for (Car car: this.cars) {
            if (car.getId().equals(id)){
                return car;
            }
        }
        return null;
    }

    public List<Car>  getByType(String type){
        List<Car> carsType = new ArrayList<>();
        for (Car car: this.cars) {
            if (car.getCarType().equals(type)){
                carsType.add(car);
            }
        }
        return carsType;
    }
}
