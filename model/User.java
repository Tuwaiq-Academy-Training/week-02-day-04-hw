package com.example.carmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;

 @Data
public class User {
    @NotEmpty(message = "ID is required")
    private String id;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotNull(message = "balance is required")
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
