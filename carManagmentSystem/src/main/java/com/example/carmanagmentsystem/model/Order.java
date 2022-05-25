package com.example.carmanagmentsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class Order {

    @NotEmpty(message = "order Id cannot be empty")
    private String id;

    @NotEmpty(message = "user Id cannot be empty")
    private String userId;

    @NotEmpty(message = "car Id cannot be empty")
    private String carId;

}
