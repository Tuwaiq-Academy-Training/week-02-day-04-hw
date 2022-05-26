package com.example.homework9.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Order {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "id is required")
    private String userid;
    @NotEmpty(message = "id is required")
    private String carid;
}
