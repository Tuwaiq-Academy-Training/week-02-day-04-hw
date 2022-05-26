package com.example.cardealershipmanagemen.Service;

import com.example.cardealershipmanagemen.Models.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
    public ArrayList<Log> longs = new ArrayList<>();
    public ArrayList<Log> getLog() {
        return longs;
    }

    public boolean addLog(String message, String id){

        Log log=new Log(message,id);
        return longs.add(log);
    }
}
