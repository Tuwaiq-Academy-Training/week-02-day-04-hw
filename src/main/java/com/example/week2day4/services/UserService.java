package com.example.week2day4.services;

import com.example.week2day4.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private ArrayList<User>users=new ArrayList<>();
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(String id) {
        for (int i = 0; i <users.size() ; i++) {
            if(users.get(i).getId().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }


}
