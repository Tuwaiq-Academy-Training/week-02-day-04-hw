package com.example.CarSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
public class Car {

    @NotEmpty(message = "Id is required")
    private String id;
    @NotEmpty(message = "Car type is required")
    @Pattern(regexp = "(Sedan|SUV|Truck)",message = "you should be choose one of this types(Sedan,SUV,Truck) ")
    private String carType;
    @NotNull(message = "Price is required")
    @Positive(message = "Price should be Positive number!!")
    private Integer price;
    @NotNull(message = "Model is required")
    private Integer model;
    @NotNull(message = "Stock is required")
    private Integer stock;
}
