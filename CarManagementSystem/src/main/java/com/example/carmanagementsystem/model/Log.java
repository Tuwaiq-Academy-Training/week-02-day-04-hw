package com.example.carmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Log {
    private static Integer ID =0;
    private Order orderMessage;
    private String message;
    private LocalDate localDate;

    public Log(String message, Order orderMessage) {
        Log.ID ++;
        this.message = message;
        this.orderMessage = orderMessage;
        this.localDate = LocalDate.now();
    }
}
