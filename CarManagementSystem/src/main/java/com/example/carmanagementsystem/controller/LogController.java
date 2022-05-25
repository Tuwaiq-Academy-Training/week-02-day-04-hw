package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.model.Log;
import com.example.carmanagementsystem.service.LogService;
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
    public ResponseEntity<ArrayList<Log>> getLogs() {
        return ResponseEntity.status(200).body(logService.getLogs());
    }

}
