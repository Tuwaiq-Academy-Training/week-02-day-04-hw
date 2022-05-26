package com.example.cardealershipmanagemen.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty (message = "id is required")
    private String id;

    @NotEmpty (message = "carType is required")
    @Pattern(regexp = "(?i)(Sedan |SUV| Truck)",message = "Car type must be (Sedan, SUV, Truck)")
    private String carType;

    @NotNull(message = "price is required")
    @Positive
    private int price;

    @NotEmpty (message = "model is required")
    @Pattern(regexp = "(\\d{4})")
    private String model;

    @NotNull (message = "stock is required")
    private int stock;
}
