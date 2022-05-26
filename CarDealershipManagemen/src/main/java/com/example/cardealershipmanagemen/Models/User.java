package com.example.cardealershipmanagemen.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@Data
public class User {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty (message = "username is required")
    private String username;
    @NotEmpty (message = "password is required")
    private String password;
    @NotNull(message = "balance is required")
    private int balance;
    private ArrayList<CarOwned> carsOwned;

    public User(String id, String username, String password, int balance, ArrayList<CarOwned> carsOwned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsOwned = new ArrayList<>();

    }
}
