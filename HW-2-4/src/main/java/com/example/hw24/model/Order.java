package com.example.hw24.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class Order {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "user is required")
    private String userid;
    @NotEmpty(message = "car id is required")
    private String carid;
}
