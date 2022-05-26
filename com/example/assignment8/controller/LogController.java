package com.example.assignment8.controller;

import com.example.assignment8.model.Log;
import com.example.assignment8.service.LogService;
import com.example.assignment8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLogs(){

        return ResponseEntity.status(200).body(logService.getLogs());
    }
}
