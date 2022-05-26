package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "id cannot be empty")
    private String id;
    @NotEmpty(message = "id cannot be empty")
    @Pattern(regexp = "(Sedan |SUV| Truck)",message = "Car type must be one of the following: Sedan, SUV or Truck")
    private String carType;
    @Positive(message = "Value must be positive")
    @NotNull(message = "id cannot be empty")
    private Integer price;
    @Pattern(regexp = "(\\d{4})",message = "Year has to be four digits")
    @NotEmpty(message = "id cannot be empty")
    private String model;
    @NotNull(message = "id cannot be empty")
    @Positive(message = "Stock number must be positive")
    private Integer stock;
}
