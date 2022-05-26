package com.example.assignment8.service;

import com.example.assignment8.model.Car;
import com.example.assignment8.model.Log;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class LogService {

    private ArrayList<Log> logs = new ArrayList<>();

    public ArrayList<Log> getLogs() {

        return logs;
    }

    public boolean addLog(String message){
        Log log = new Log(message);
        return logs.add(log);
    }




}
