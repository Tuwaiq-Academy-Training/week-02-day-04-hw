package com.example.cardealership.Controllers;

import com.example.cardealership.Models.Api;
import com.example.cardealership.Models.Logs;
import com.example.cardealership.Services.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@RequestMapping("api/v1/logs")
public class LogsController {
    private final LogsService logsService;

    @GetMapping
    public ResponseEntity<ArrayList<Logs>> getLogs(){
        if (logsService.getLogs()==null)
        return ResponseEntity.status(400).body(logsService.getLogs());
        return ResponseEntity.status(200).body(logsService.getLogs());

    }

    @PostMapping
    public ResponseEntity<Api> addLogs(@RequestBody @Valid Logs logs , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        if(!(logsService.addLog(logs))) {
            return ResponseEntity.status(400).body(new Api("This log is already exit", 400));
        }return ResponseEntity.status(200).body(new Api("Added logs",200));


    }



}
