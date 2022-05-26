package com.example.carmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "ID is required")
    private String id;
    @NotEmpty(message = "carType is required")
    @Pattern(regexp = "(Sedan|SUV|Truck)",message = "your type must be (Sedan |SUV| Truck)")
    private String carType;
    @NotNull(message = "price is required")
    @Range(min = 5000,message = "Your price must be more than 5k")
    private Integer price;
    @NotEmpty(message = "model is required")
    private String model;
    @NotNull(message = "stock is required")
    private Integer stock;
}
