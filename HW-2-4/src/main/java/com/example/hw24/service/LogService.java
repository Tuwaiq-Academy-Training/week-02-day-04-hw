package com.example.hw24.service;

import com.example.hw24.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
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
