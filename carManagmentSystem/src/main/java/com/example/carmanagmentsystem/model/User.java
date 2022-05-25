package com.example.carmanagmentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.util.ArrayList;


@AllArgsConstructor
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

    @NonNull
    private ArrayList<Car> userCars;
}
