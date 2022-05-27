package com.example.cardealershipproj.Controllers;


import com.example.cardealershipproj.models.Logs;
import com.example.cardealershipproj.services.LogsServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/log")
@AllArgsConstructor
public class LogsController {

    private final LogsServices logsServices ;
    @GetMapping
    public ResponseEntity<ArrayList<Logs>> getLogs(){
        return ResponseEntity.status(200).body(logsServices.getLogs());
    }
}
