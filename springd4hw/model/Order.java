package com.example.springd4hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class Order {
    @NotEmpty(message = "id can not be empty !")
    private String id;
    @NotEmpty(message = "User id can not be empty !")
    private String userid;
    @NotEmpty(message = "Car id can not be empty !")
    private String carid;
}
