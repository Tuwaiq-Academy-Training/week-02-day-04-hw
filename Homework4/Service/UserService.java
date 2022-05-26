package com.demo.Homework4.Service;

import com.demo.Homework4.Model.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private ArrayList<User> users = new ArrayList();

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean addUsers(User user) {
        return users.add(user);
    }

    public User getUser(String userID) {
        for (User user:users) {
            if(user.getId().equals(userID)){
                return user;
            }
        }
        return null;
    }
}
