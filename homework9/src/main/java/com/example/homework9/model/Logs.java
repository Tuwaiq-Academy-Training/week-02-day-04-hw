package com.example.homework9.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data

public class Logs {
    private String message;
    private LocalDate date;
private Integer id  ;
    public Logs(Integer id,String message){
        this.id=id;
        this.message=message;
        date=LocalDate.now();
    }
}
