package com.example.carmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

 @Data
public class Order {
    private static Integer ID;
    private String userID;
    private String carID;

    public Order(String userID, String carID) {
        this.ID += 1;
        this.userID = userID;
        this.carID = carID;
    }
}
