package com.example.assignment8.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Car {

    @NotEmpty(message = "id is required")
    private String id;

    @NotEmpty(message = "Car type is required")
    @Pattern(regexp = "(Sedan |SUV| Truck)")
    private String carType;

    @NotNull(message = "price is required")
    private Integer price;

    @NotEmpty(message = "Model is required")
    private String model;

    @NotNull(message = "Stock is required")
    private Integer stock;


}
