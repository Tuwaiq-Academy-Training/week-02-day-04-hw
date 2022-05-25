package com.example.carmanagementsystem.service;


import com.example.carmanagementsystem.model.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    private ArrayList<Log> logs = new ArrayList<>();
    public ArrayList<Log> getLogs() {
        return logs;
    }

    public boolean addLog(Log log) {
        return logs.add(log);
    }
}
