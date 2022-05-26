package com.example.springd4hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class Car {
    @NotEmpty(message = "id can not be empty !")
    private String id;

    @NotEmpty(message = "car type can not be empty !")
    @Pattern(regexp = ("Sedan|SUV|Truck"),message = "car type should be Sedan ,SUV or Truck")
    private String carType;

    @NotNull(message = " price can not be empty !")
    @Min(value = 1000,message = " price start from 1000 riyals :) ")
    private Integer price;

    @NotNull(message = " model can not be empty !")
    private Integer model;

    private Integer stock;
}
