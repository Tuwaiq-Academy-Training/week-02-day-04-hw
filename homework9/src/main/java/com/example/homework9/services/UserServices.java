package com.example.homework9.services;

import com.example.homework9.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor


public class UserServices {

    private ArrayList<Users> users= new ArrayList<>();

    public ArrayList<Users> getUser(){
        return  users;
    }
    public boolean addUser(Users user) {
        return users.add(user);
    }

    public Users getUser(String userid) {
        for (Users user:users) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }

}
