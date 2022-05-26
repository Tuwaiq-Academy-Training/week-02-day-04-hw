package com.demo.Homework4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Logs {
    @NotEmpty(message = "logsID is required")
    private String logs_ID;

    @NotNull(message = "message is required")
    private String message;

    public Logs(String message) {
        this.message = message;
    }
}
