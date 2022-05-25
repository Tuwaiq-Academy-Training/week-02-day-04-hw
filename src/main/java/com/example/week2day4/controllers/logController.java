package com.example.week2day4.controllers;

import com.example.week2day4.model.ResponseApi;
import com.example.week2day4.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/log")
@RequiredArgsConstructor
public class logController {
    private final LogService logService;

    @GetMapping
    public ResponseEntity getLogs(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }
}
