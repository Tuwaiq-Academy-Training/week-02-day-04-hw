package com.example.car.User;

import com.example.car.Car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
public class User {

    @NotEmpty(message = "ID can't be empty")
    private String ID;
    @NotEmpty(message = "username can't be empty")
    @Size(min = 3, message = "Min is 3")
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6, message = "Min is 6")
    private String password;
    @NotNull(message = "balance can't be empty")
    @Positive(message = "balance have to be Positive")
    private Integer balance;
    @NotEmpty(message = "carsOwned can't be empty")
    private ArrayList<Car> carsOwned;

    public User(String ID, String username, String password, Integer balance, ArrayList<Car> carsOwned) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsOwned = new ArrayList<>();
    }


    public boolean addNewCar(Car newCar){
        return carsOwned.add(newCar);

    }

    public void removeCar(Car car) {



    }
}
