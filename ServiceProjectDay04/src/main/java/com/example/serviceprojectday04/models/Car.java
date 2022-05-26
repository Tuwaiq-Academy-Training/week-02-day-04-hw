package com.example.serviceprojectday04.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
@AllArgsConstructor @Data
public class Car {
    @NotNull
    private String id;
    @NotNull @Pattern(regexp = "(Sedan|SUV|Truck)")
    private String type;
    @NotNull @PositiveOrZero
    private Double price;
    @NotNull
    private String model;
    @NotNull @PositiveOrZero
    private Integer stock;
}
