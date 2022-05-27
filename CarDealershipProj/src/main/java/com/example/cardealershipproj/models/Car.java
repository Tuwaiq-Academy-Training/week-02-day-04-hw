package com.example.cardealershipproj.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "id is required")
    private String id ;

    @NotEmpty(message = "carType is required")
    @Pattern(regexp = "(Sedan |SUV| Truck)")
    private String carType;

    @NotNull(message = "price of the car is required!")
    @Positive
    private Integer price;

    @NotEmpty(message = "model of the car is required!")
    private String model;

    @NotNull(message = "please specify the Stock")
    @Positive
    private Integer stock;



}
