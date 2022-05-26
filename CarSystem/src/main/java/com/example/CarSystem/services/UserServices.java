package com.example.CarSystem.services;

import com.example.CarSystem.models.Car;
import com.example.CarSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices {
    private ArrayList<User> userList=new ArrayList<>();

    public ArrayList<User> getUsers(){
        return userList;
    }

    public boolean addUser(User newUser){
        return userList.add(newUser);
    }

    public User getUser(String userid) {
        for (User user:userList) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }
}
