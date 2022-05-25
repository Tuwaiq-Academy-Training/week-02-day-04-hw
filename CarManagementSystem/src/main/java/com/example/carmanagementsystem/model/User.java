package com.example.carmanagementsystem.model;

import com.example.carmanagementsystem.service.CarService;
import com.example.carmanagementsystem.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

//@AllArgsConstructor
@Data
public class User {
    private final CarService carService;
    @NotEmpty(message = "userID is required!")
    @Size(min = 2,message = "userID must be more than 2")
    private String userID;
    @NotEmpty(message = "username is required!")
    @Size(min = 3,message = "username must be more than 3")
    private String username;
    @NotEmpty(message = "password is required!")
    @Size(min = 4, message = "should be 4 letters or more")
    private String password;
    @NotNull(message = "balance is required!")
    private Double balance;
    @JsonIgnore
    private ArrayList<Car> carsOwned;

    public User (String userID, String username,String password,Double balance) {
        carService = new CarService(new UserService());
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsOwned = new ArrayList<>();
    }


    public void addNewCar(Car car) {
        carsOwned.add(car);
        System.out.println(carsOwned);
    }

    public void removeCar(Car car) {
        carsOwned.remove(car);
    }
}
