package com.example.demo.controller;

import com.example.demo.model.Logs;
import com.example.demo.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/log")
@RequiredArgsConstructor
public class LogsController {
    private final LogService logService;
    @GetMapping
    public ResponseEntity<ArrayList<Logs>> getLogs(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }
}
