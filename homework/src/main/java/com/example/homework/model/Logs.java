package com.example.homework.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Logs {
    private String id;
    private String message;
    private LocalDate date;

    public Logs(String message){
        this.message=message;
        date=LocalDate.now();
    }
}
