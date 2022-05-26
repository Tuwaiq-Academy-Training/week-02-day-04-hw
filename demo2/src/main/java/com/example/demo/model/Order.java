package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "Order id cannot be empty")
    private String id;
    @NotEmpty(message = "User id cannot be empty")
    private String userID;
    @NotEmpty(message = "Car id cannot be empty")
    private String carID;

}
