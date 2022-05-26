package com.example.carmanagmentsystem.controller;
import com.example.carmanagmentsystem.service.LogService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/logs")
@RequiredArgsConstructor

public class LogController {
    private final LogService logService;

    @GetMapping
    public ResponseEntity getAllLogs(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }

}
