package com.example.cardealership.service;

import com.example.cardealership.model.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    private ArrayList<Log> logs=new ArrayList();

    public ArrayList<Log> getLogs(){
        return  logs;
    }

    public boolean addLog(String message){
        Log log=new Log(message);
        return logs.add(log);
    }
}