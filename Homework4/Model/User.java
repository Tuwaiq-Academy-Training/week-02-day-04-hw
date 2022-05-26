package com.demo.Homework4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
public class User {
    @NotEmpty(message = "userID is required")
    private String id;

    @Size(min = 4, message = "username have to be more than 4")
    @NotEmpty(message = "username is required")
    private String username;

    @Size(min = 6, message = "username have to be more than 6")
    @NotEmpty(message = "password is required")
    private String password;

    @NotNull(message = "balance is required")
    private Integer balance;

    @NotEmpty(message = "carsOwned is required")
    private ArrayList <Car> carsOwned;

    public User(String id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsOwned = new ArrayList<>();
    }
}


