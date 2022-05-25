package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.model.LoginForm;
import com.example.carmanagementsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>();
    
    public ArrayList<User> getUsers() {
        return users;
    }
    
    public User getUser(String userID) {
        for (User user : users) {
            if(user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
    
    public User checkIfUserExist(String userID) {
        User curUser = getUser(userID);
        return curUser;
    }

    public Boolean add(User user) {
        return users.add(user);
    }

    public Integer validation(LoginForm loginForm) {
        User user = checkIfUserExist(loginForm.getUsername());
        if(user == null){
            return -1;
        }
        if (!user.getPassword().equals(loginForm.getPassword())) {
            return 0;
        }
        return 1;
    }
}
