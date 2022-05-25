package com.example.week2day4.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Log {
    private String id;
    private String message;
    private LocalDate logdate;
    public Log(String message){
        this.message=message;
        logdate=LocalDate.now();
        id=Math.random()+"";

    }
}
