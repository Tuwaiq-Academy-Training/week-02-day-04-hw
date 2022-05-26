package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@Data @AllArgsConstructor
public class User {
    @NotEmpty(message = "User id cannot be empty")
    private String id;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotNull(message = "User balance cannot be empty")
    private Integer balance;
    private ArrayList<CarsOwned> carsOwned;


}
