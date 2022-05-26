package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Logs {
    private String id;
    private String message;
    private LocalDate date;

    public Logs(String id,String message){
        this.id = id;
        this.message = message;
        date = LocalDate.now();
    }
}
