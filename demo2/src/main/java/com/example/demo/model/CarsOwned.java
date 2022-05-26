package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
@AllArgsConstructor @Data
public class CarsOwned {

    private String id;
    private String carType;
    private Integer price;
    private String model;
}
