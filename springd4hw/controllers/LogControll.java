package com.example.springd4hw.controllers;

import com.example.springd4hw.model.Log;
import com.example.springd4hw.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("log")
@RequiredArgsConstructor
public class LogControll {

    private final LogService logService;


    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLogs(){
     return ResponseEntity.status(200).body(logService.getlogs());
    }


}
