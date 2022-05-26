package com.example.homework9.services;


import com.example.homework9.model.Car;
import com.example.homework9.model.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class LogsServices {

    private ArrayList<Logs> logs=new ArrayList();

    public ArrayList<Logs> getLogs(){
        return  logs;
    }

    public boolean addLog(Integer id,String message){
        Logs log=new Logs(id,message);
        return logs.add(log);
    }




}
