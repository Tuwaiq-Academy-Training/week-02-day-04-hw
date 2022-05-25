package com.example.carmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class UserOwnedCar {
    private String carID;
    private String carType;
    private Double price;
    private String model;
}
