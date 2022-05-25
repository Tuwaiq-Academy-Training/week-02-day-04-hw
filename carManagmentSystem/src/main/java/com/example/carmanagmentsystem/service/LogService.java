package com.example.carmanagmentsystem.service;


import com.example.carmanagmentsystem.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class LogService {

    ArrayList<Log> systemLogs = new ArrayList<Log>();

    public ArrayList<Log> getLogs(){
        return systemLogs;
    }

    public boolean addLog(String message){
        System.out.println(message);
       return systemLogs.add(new Log(message));
    }
}
