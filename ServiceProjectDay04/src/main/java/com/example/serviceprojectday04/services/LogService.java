package com.example.serviceprojectday04.services;

import com.example.serviceprojectday04.models.Logs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    private ArrayList<Logs> logs=new ArrayList();

    public ArrayList<Logs> getLogs(){
        return logs;
    }
    public boolean addLog(String message){
        Logs log=new Logs(message);
        return logs.add(log);
    }

}
