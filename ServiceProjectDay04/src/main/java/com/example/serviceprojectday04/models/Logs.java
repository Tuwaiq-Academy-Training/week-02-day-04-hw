package com.example.serviceprojectday04.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Logs {
    private String message;
    private LocalDate date;

    public Logs(String message) {
        this.message = message;
        date =LocalDate.now();
    }
}
