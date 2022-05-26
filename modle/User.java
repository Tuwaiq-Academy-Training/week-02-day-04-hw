package com.example.cardealershipmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "user is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 30)
    @Pattern(regexp = "\"^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\"")
    private Integer password;
    @NotEmpty(message = "Balance is required")
    @Positive(message = "Balance have to be positive")
    private Integer balance = 0;
    private ArrayList<Car> carsOwneds;

//    public User(String id, String username, String password, Integer balance, ArrayList<Car> carsOwned) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.balance = balance;
//        this.carsOwned = new ArrayList<>();
//    }

}