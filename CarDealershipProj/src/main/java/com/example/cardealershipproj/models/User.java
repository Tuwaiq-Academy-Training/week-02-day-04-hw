package com.example.cardealershipproj.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

 @Data
public class User {

    @NotEmpty(message = " id is required!")
    @Size(min = 3, message = "id must be three digit id")
    private String id;

    @NotEmpty(message = " username is required!")
    @Size(min = 3, message = "username must be more than three chars")
    private String username;

    @NotEmpty(message ="password is required")
    @Size(min = 6 ,message = "password must be more tha 6 chars")
    private String password;

    @NotNull(message = "balance is required ")
    @Positive(message = "please enter a valid balance")
    private Integer balance;


    private ArrayList<Car> carOwned;

    public User(String id, String username, String password, Integer balance, ArrayList<Car> carOwned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carOwned = new ArrayList<>();// cuz not return null
    }
}
