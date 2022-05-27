package com.example.cardealershipproj.services;

import com.example.cardealershipproj.models.Logs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogsServices {

    private ArrayList<Logs> logs=new ArrayList();

    public ArrayList<Logs>getLogs(){
        return  logs;
    }

    public boolean addLog(String message , String id){
        Logs log=new Logs( message , id);
        return logs.add(log);
    }


}
