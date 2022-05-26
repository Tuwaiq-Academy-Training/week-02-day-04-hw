package com.demo.Homework4.Service;

import com.demo.Homework4.Model.Car;
import com.demo.Homework4.Model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {
    private ArrayList<Car> carList = new ArrayList();
    private final UserService userService;

    public ArrayList<Car> getCar() {
        return carList;
    }

    public boolean addCar(Car newCar) {
        return carList.add(newCar);
    }

    public ArrayList<Car> getCarByType(String type) {
        ArrayList<Car> carsType = new ArrayList<>();

        for (Car car : carList) {
            if (car.getCarType().equals(type)) {
                carsType.add(car);
            }
        }

        return carsType;
    }

    public Integer purchaseCar(String userid, String carid) {
        Car car = getCar(carid);
        User user = userService.getUser(userid);

        if (car == null || user == null) {
            return -1;
        }

        if (user.getBalance() < car.getPrice()) {
            return 0;
        }

        if (car.getStock() == 0) {
            return 1;
        }

        Integer oldStock = car.getStock();
        car.setStock(oldStock - 1);

        Integer oldBalance = user.getBalance();
        user.setBalance(oldBalance - car.getPrice());

        user.getCarsOwned().add(car);

        return 2;
    }

    public Integer sellaCar(String userid, String carid) {
        Car car = getCar(carid);
        User user = userService.getUser(userid);

        if (car == null || user == null) {
            return -1;
        }

        if (!user.getCarsOwned().contains(car)) {
            return 0;
        }
        car.setStock(car.getStock() + 1);
        user.setBalance(user.getBalance() + car.getPrice());
        user.getCarsOwned().remove(car);

        return 1;
    }

    public Car getCar(String cardid) {
        for (Car car : carList) {
            if (car.getId().equals(cardid)) {
                return car;
            }
        }
        return null;
    }

}
