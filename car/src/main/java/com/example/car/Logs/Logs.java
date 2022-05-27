package com.example.car.Logs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;

 @Data
public class Logs {

    private String ID;
    private String message;
    private LocalDate localDate;

     public Logs(String ID, String message, LocalDate localDate) {
         this.ID = ID;
         this.message = message;
         this.localDate = localDate.now();
     }

     public String getID() {
         return ID;
     }

     public void setID(String ID) {
         this.ID = ID;
     }

     public String getMessage() {
         return message;
     }

     public void setMessage(String message) {
         this.message = message;
     }

     public LocalDate getLocalDate() {
         return localDate;
     }

     public void setLocalDate(LocalDate localDate) {
         this.localDate = localDate;
     }
 }
