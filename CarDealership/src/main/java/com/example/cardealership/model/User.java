package com.example.cardealership.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @PositiveOrZero(message = "balance must be 0 or more")
    private Integer balance;
    private ArrayList<Car> carsOwned;
}
