package com.example.cardealershipmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Car {

    @NotEmpty(message = "Id is required")
    @Size(min = 2, message = "It has to be that size")
    private String id;
    @NotEmpty(message = "Type is required")
    @Pattern(regexp = "(Sedan |SUV| Truck)", message = "Car must be in (Sedan |SUV| Truck)")
    private String carType;
    @NotNull(message = "Type is required")
    @Positive(message = "Price have to be positive")
    private Integer price;
    @NotEmpty(message = "Model is required")
    private String model;
    @NotNull(message = "Stock is required")
    @Positive(message = "Stock have to be positive")
    private Integer stock;
}
