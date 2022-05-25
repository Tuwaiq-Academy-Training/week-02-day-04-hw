package com.example.carmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

 @Data
public class Order {
    private static Integer ID =0;
    private String userID;
    private String carID;

    public Order(String userID, String carID) {
        Order.ID ++;
        this.userID = userID;
        this.carID = carID;
    }
}
