package com.example.cardealershipmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "Id is required")
    @Size(min = 2, message = "It has to be that size")
    private String id;
    @NotEmpty(message = "User id is required")
    private String userId;
    @NotEmpty(message = "Car id is required")
    private String carId;

}
