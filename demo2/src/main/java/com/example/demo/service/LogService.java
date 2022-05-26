package com.example.demo.service;

import com.example.demo.model.Logs;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    ArrayList<Logs> logs =new ArrayList<>();

    public ArrayList<Logs> getLogs(){
        return logs;
    }
    public boolean addLog(String message){
        Integer id = logs.size()+1;
        Logs log = new Logs(id.toString(),message);
        return logs.add(log);
    }
}
