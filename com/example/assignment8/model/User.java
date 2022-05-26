package com.example.assignment8.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class User {

    @NotEmpty(message = "Id is required")
    private String id;

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotNull(message = "Balance is required")
    private Integer balance;

    private ArrayList<Car> carOwned;

    public User(String id, String username, String password, Integer balance, ArrayList<Car> carOwned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carOwned = new ArrayList<>();
    }
}
