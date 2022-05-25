package com.example.carmanagmentsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;


@AllArgsConstructor
@Data
public class Car {

    @NotEmpty(message = "car id cannot be empty")
    @Size(min=3, message = "minim size of id is 3")
    private String id;

    @NotEmpty(message = "car type cannot be empty")
    @Pattern(regexp = "(Truck|SUV|Sedan)")
    private String carType;


    @NotNull(message = "car price cannot be empty")
    @Min(value = 20000)
    private Double price;

    @NotEmpty(message = "car model cannot be empty")
    @Pattern(regexp = "20[0-2][0-2]", message = "must be valid year between 1900 to 2000")
    private String model;

    @Min(value = 1)
    @NotNull(message = "car stock cannot be empty")
    private Integer stock;

}
