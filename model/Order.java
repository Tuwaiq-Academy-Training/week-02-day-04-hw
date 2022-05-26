package com.example.carmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "ID is required")
    private String id;
    @NotEmpty(message = "userid is required")
    private String userid;
    @NotEmpty(message = "carID is required")
    private String carID;
}
