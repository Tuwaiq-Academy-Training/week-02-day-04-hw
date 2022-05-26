package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service

public class UserService {
    ArrayList<User> users= new ArrayList<>();

    public boolean addUser(User user){
        return users.add(user);
    }
    public  ArrayList<User> getUsers(){
        return users;
    }



    public User findUserById(String userID){
        for (User user:users) {
            if(user.getId().equals(userID)){
                return user;
            }
        }
        return null;
    }

}
