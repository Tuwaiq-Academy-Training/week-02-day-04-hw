package com.demo.Homework4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
public class Car {

    @NotEmpty(message = "ID is required")
    private String id;

    //Create endpoint that lists cars by type (Sedan |SUV| Truck)
    @Pattern(regexp = "Sedan |SUV| Truck", message = "You role must be in (Sedan,SUV,Truck)")
    @NotEmpty(message = "carType is required")
    private String carType;

    @Range(min= 10000)
    @Positive(message = "Price have to be positive")
    @NotNull(message = "Price is required")
    private Integer price;

    @NotEmpty(message = "Model is required")
    private String model;

    @Positive(message = "Stock have to be positive")
    @NotNull(message = "stock is required")
    private Integer stock;

}
