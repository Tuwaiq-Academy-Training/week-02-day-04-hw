package com.example.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Data
public class Car {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "carType is required")
    @Pattern(regexp = "(Sedan|SUV|Truck)",
            message = "car must be in (Sedan|SUV|Truck)")
    private String carType;
    @NotNull(message = "price is required")
    @Positive(message = "price must be positive")
    @Range(min = 5000)
    private Integer price;
    @NotEmpty(message = "model is required")
    private String model;
    @NotNull(message = "stock is required")
    @Positive(message = "Stock have to be positive")
    private Integer stock;



}
