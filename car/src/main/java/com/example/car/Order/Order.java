package com.example.car.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class Order {

    @NotEmpty(message = "ID can't be empty")
    private String ID;
    @NotEmpty(message = "carType can't be empty")
    private String userid;
    @NotEmpty(message = "price can't be empty")
    private String carid;

}
