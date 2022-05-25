package com.example.cardealership.controllers;

import com.example.cardealership.model.Log;
import com.example.cardealership.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLogs(){
        return ResponseEntity.status(HttpStatus.OK).body(logService.getLogs());
    }
}
