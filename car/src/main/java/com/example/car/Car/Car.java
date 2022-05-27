package com.example.car.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@AllArgsConstructor @Data
public class Car {

    @NotEmpty(message = "ID can't be empty")
    private String ID;
    @NotEmpty(message = "carType can't be empty")
    @Pattern(regexp = "(Sedan|SUV|Truck)", message = "carType most be (Sedan|SUV|Truck) ")
    private String carType;
    @NotNull(message = "price can't be empty")
    @Positive(message = "price have to be Positive")
    @Range(min = 25000,message = "Min price is 25000")
    private Integer price;
    @NotEmpty(message = "model can't be empty")
    private String model;
    @NotNull(message = "stock can't be empty")
    @Positive(message = "stock have to be Positive")
    private Integer stock;





}
