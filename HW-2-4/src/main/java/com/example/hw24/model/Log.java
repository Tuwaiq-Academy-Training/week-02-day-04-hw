package com.example.hw24.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Log {
    private String message;
    private LocalDate date;

    public Log(String message){
        this.message=message;
        date=LocalDate.now();
    }
}
