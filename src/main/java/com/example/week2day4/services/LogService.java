package com.example.week2day4.services;

import com.example.week2day4.model.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
private ArrayList<Log>logs=new ArrayList<>();
    public ArrayList<Log> getLogs() {
        return logs;
    }
    public boolean addLog(String message){
        Log log=new Log(message);
        return logs.add(log);
    }
}
