package com.example.cardealership.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Data
public class Car {
    @NotEmpty(message = "id is required")
    private String id;
    @Pattern(regexp = "sedan |suv| truck", message = "not a valid car type, only accepting Sedan, SUV and Truck ")
    private String carType;
    @Positive(message = "price must be 0 or more")
    private Integer price;
    @NotEmpty(message = "model is required")
    private String model;
    @PositiveOrZero(message = "stock must be 0 or more")
    private Integer stock;
}
