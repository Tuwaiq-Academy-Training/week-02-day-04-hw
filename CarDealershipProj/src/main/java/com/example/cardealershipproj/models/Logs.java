package com.example.cardealershipproj.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

// always start w model
@AllArgsConstructor @Data
public class Logs {


    private String message;
    private String id;
    private LocalDate date;

    public Logs(String message, String id ){
        this.message=message;
        this.id = id;
        date=LocalDate.now();
    }
    
}
