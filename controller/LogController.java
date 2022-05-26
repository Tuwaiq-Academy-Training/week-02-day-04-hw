package com.example.cardealershipmanagementsystem.controller;


import com.example.cardealershipmanagementsystem.models.Log;
import com.example.cardealershipmanagementsystem.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("Api/v1/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;


    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLogs(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }
}
