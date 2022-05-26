package com.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

 @Data
public class User {

    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "the id great than 2")
    private String id;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    @Size(min = 8,message = "the id great than 7")
    private String password;
    @NotNull(message = "phoneNumber is required")
    @Digits(integer = 10,fraction = 5)
    private Integer balance;
    @NotEmpty(message = "the array no empty")
    private ArrayList<Car> carsOwned;

     public User(String id, String username, String password, Integer balance, ArrayList<Car> carsOwned) {
         this.id = id;
         this.username = username;
         this.password = password;
         this.balance = balance;
         this.carsOwned =new ArrayList<>();
     }
 }
