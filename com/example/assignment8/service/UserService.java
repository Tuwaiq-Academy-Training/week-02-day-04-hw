package com.example.assignment8.service;

import com.example.assignment8.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addUsers(User user){
        return users.add(user);
    }

    public User getUser(String userid) {
        for (User user:users) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }
}
