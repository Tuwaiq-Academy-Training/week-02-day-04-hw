package com.example.carmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "carID is required!")
    private String carID;
    @NotEmpty(message = "carType is required!")
    @Pattern(regexp = "(Sedan |SUV| Truck)", message = "carType should be (Sedan |SUV| Truck) !")
    private String carType;
    @NotNull(message = "price is required!")
    private Double price;
    @NotEmpty(message = "model is required!")
    private String model;
    @NotNull(message = "stock is required!")
    @Min(1)
    private Integer stock;
}
