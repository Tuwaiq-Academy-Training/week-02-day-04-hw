package com.example.carmanagment.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Logs {
   @NotEmpty(message = "ID is required")
   private String id;
   @NotEmpty(message = "username is required")
   private String message;
   @NotEmpty(message = "password is required")
   private LocalDate localDate;

    public Logs(String id, String message) {
        this.id = id;
        this.message = message;
        this.localDate = LocalDate.now();
    }
}
