package com.example.hw24.controllers;

import com.example.hw24.model.Log;
import com.example.hw24.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;
    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLogs(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }

}
