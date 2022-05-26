package com.example.springd4hw.services;

import com.example.springd4hw.model.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {

    private ArrayList<Log> logs=new ArrayList();

    public ArrayList getlogs(){
        return logs;
    }
}
