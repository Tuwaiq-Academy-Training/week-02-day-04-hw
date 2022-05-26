package com.example.hw24.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class User {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "user is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min=6 , max = 20)
    private String password;
    private Integer balance;
    private ArrayList<Car> carsowen;
    public User(String id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.carsowen = new ArrayList<>();
    }
}
