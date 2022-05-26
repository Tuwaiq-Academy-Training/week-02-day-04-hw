package com.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "the id great than 2")
    private String id;
    @NotEmpty(message = "carType is required")
    @Pattern(regexp = "(Sedan | SUV | Truck)",
            message = "car must be in  (Sedan | SUV | Truck)")
    private String carType;
    @NotEmpty(message = "price is required")
    @Positive
    @Range(min = 5000)
    private Integer price;
    @NotEmpty(message = "model is required")
    private String model;
    @NotNull(message = "stock is required")
    @Positive
    private Integer stock;
}
