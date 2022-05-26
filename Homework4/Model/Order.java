package com.demo.Homework4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class Order {

    @NotEmpty(message = "ID is required")
    private String id;

    @NotEmpty(message = "userID is required")
    private String userid;

    @NotEmpty(message = "password is required")
    private String password;

}
