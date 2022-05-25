package com.example.week2day4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "you must enter an id")
    private String id;
    @NotEmpty(message = "You must enter a userid")
    private String userid;
    @NotEmpty(message = "You must enter a carid")
    private String carid;

}
