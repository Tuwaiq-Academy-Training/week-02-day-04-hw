package com.example.assignment8.model;

import lombok.Data;

@Data
public class Log {

    private String id;
    private String message;

    public Log(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
