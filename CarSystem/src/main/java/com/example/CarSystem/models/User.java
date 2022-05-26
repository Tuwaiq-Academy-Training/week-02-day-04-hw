package com.example.CarSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;

@Data
public class User {
    @NotEmpty(message = "Id is required")
    private String id;
    @NotEmpty(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
                          message = "Password should be have Uppercase and lowercase letters, numbers and symbols" )
    private String password;
    @NotEmpty(message = "Balance is required")
    private Integer balance;
    private ArrayList<Car> carsOwned;

    public User(String id, String username, String password, Integer balance, ArrayList<Car> carsOwned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsOwned = new ArrayList<>();
    }
}
