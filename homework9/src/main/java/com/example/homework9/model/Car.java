package com.example.homework9.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class Car {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "name is required")
    @Pattern(regexp = "(Sedan|SUV|Truck)",message = "the type must be one of this type (Sedan,SUV,Truck)")
    private String carType;
    @NotNull(message = "price is required")
    private Integer price;
    @NotEmpty(message = "model is required")
    private String model;
    @NotNull(message = "stock is required")
    private Integer stock;



}
