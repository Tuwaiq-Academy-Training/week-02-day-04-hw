package com.example.carmanagmentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.util.ArrayList;


@Data
public class User {
    @NotEmpty(message = "id is required")
    @Size(min=4)
    private String id;

    @NotEmpty(message = "username is required")
    @Size(min=4)
    private String username;

    @NotEmpty(message = "password is required")
    @Size(min=4)
    private String password;

    @NotNull(message = "balance is required")
    @PositiveOrZero(message = "PLease add valid number")
    private Double balance;

    private ArrayList<Car> userCars;

    public User(String id, String username, String password, Double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.userCars = new ArrayList<>();
    }
}
