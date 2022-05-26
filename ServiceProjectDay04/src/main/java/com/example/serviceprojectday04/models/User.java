package com.example.serviceprojectday04.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class User {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotNull @PositiveOrZero
    private Double balance;
    private ArrayList<Car> carsOwned;
}
