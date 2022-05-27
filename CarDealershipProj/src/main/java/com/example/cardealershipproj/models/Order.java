package com.example.cardealershipproj.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Order {


    @NotEmpty(message = " ID is required!")
    @Size(min = 3, message = "must be three digit id")
    private String ID;

    @NotEmpty(message = " userId is required!")
    @Size(min = 3, message = "must be three digit id")
    private String userId;

    @NotEmpty(message = " carId is required!")
    @Size(min = 3, message = "must be three digit id")
    private String carId;


    
}
