package com.example.cardealershipmanagementsystem.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class Log {

//    @NotEmpty(message = "Id is required")
    private String id;
//    @NotEmpty(message = "Message is required")
    private String message;

    private LocalDate localDate;


    public Log(String id, String message, LocalDate localDate) {
        this.id = id;
        this.message = message;
        this.localDate = localDate.now();
    }
}
