package com.example.cardealership.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class Order {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "user id is required")
    private String userid;
    @NotEmpty(message = "car id is required")
    private String carid;
}
