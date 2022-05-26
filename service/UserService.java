package com.example.cardealershipmanagementsystem.service;

import com.example.cardealershipmanagementsystem.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class UserService {


    private ArrayList<User> users = new ArrayList();
    public ArrayList<User> getUser(){
        return users;
    }
    public boolean addUser(User user)
    {
        return users.add(user);
    }
    public User getUser(String userid){
        for (User user:users) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }


}
