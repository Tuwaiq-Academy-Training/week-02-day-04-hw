package com.example.homework9.controller;

import com.example.homework9.model.Logs;
import com.example.homework9.services.LogsServices;
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



        private final LogsServices logService;
        @GetMapping
        public ResponseEntity<ArrayList<Logs>> getLogs(){
            return ResponseEntity.status(200).body(logService.getLogs());
        }
    }

