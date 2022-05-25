package com.example.hw24.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class Car {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "car type is required")
    @Pattern(regexp = "Sedan |SUV| Truck")
    private String cartype;
    @NotNull(message = "price is required")
    private Integer price;
    private String model;
    private Integer stock;
}
