package com.example.week2day4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ResponseApi {
    private String message;
    private Integer status;
}
