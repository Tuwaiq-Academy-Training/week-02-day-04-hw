package com.example.week2day4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "please enter an id")
    private String id;
    @NotEmpty(message = "please enter a car type")
    private String carType;
    @NotNull(message = "please enter a price")
    @Positive(message = "car price should be greater than 0")
    private Integer price;
    @NotEmpty(message = "please enter a model")
    private String model;
    @NotNull(message = "please enter the number of stock")
    @PositiveOrZero(message = "stock can't be less than 0")
    private Integer stock;
}
