package com.example.cardealership.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Order {
    @NotNull
    @Size(min = 2,message = "Must be more than 2 numbers")
    private String orderid;

    @NotNull
    @Size(min = 2,message = "Must be more than 2 numbers")
    private String carid;

    @NotNull
    @Size(min = 2,message = "Must be more than 2 numbers")
    private String userid;


}
