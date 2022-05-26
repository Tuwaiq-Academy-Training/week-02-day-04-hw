package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class CarType {
    @NotEmpty(message = "id cannot be empty")
    @Pattern(regexp = "(Sedan |SUV| Truck)",message = "Car type must be one of the following: Sedan, SUV or Truck")
    private String carType;
}
