package com.example.homework9.model;

import com.example.homework9.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@AllArgsConstructor
@Data
public class Users {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotNull(message = "balance is required")
    private Integer balance;
    private ArrayList<Car> carsowned;

    public Users(String id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsowned = new ArrayList<>();
    }
}
