package com.example.cardealership.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Car {
    @NotNull
    @Size(min = 2,message = "Must be more than 2 numbers")
    private String carid;

    @NotNull
    @Pattern(regexp = "(Sedan |SUV| Truck)")
    private String type;

    @NotNull
    @Min(value = 50000 , message = "Price must be bigger than 50,000")
    private Integer price;

    @NotNull
    private String model;

    @NotNull
    private Integer stock;

}
