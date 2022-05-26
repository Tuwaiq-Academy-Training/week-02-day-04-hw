package com.example.CarSystem.services;

import com.example.CarSystem.models.Logs;
import com.example.CarSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogsServices {
    private ArrayList<Logs> logs = new ArrayList();

    public ArrayList getLogs(){
        return logs;
    }

}
