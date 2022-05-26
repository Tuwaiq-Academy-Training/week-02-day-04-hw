package com.example.serviceprojectday04.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "id is required")
    private String userId;
    @NotNull
    private String carId;
}
