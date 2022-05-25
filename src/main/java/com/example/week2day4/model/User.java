package com.example.week2day4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@Data
public class User {
    @NotEmpty(message = "please enter an id")
    private String id;
    @NotEmpty(message = "please enter a username")
    private String username;
    @NotEmpty(message = "please enter a password")
    private String password;
    @NotNull(message = "balance is required")
    private Integer balance;
    private ArrayList<Car>owned_cars;

    public User(String id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.owned_cars = new ArrayList<>();
    }
}
