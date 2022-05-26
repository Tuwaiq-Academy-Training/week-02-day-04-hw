package com.example.CarSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor @Data
public class Logs {
    private String id;
    private String message;
    private LocalDate localDate;

    public Logs(String id, String message) {
        this.id = id;
        this.message = message;
        this.localDate = localDate.now();
    }
}
