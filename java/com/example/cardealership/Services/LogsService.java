package com.example.cardealership.Services;

import com.example.cardealership.Models.Logs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogsService {

    private ArrayList<Logs> log=new ArrayList();


    public ArrayList<Logs> getLogs(){
        return  log;
    }

    public boolean addLog(Logs logs){
        return log.add(logs);
    }
}
