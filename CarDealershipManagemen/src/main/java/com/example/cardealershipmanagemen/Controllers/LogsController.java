package com.example.cardealershipmanagemen.Controllers;

import com.example.cardealershipmanagemen.Models.Log;
import com.example.cardealershipmanagemen.Service.LogService;
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

    public final LogService logService;

    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLog(){
        return ResponseEntity.status(200).body(logService.getLog());
    }
}
