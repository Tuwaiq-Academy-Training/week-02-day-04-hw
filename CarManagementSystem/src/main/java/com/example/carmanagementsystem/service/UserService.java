package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.model.LoginForm;
import com.example.carmanagementsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>();
    
    public User getUser(String userID) {
        User curU = null;
        for (User user : users) {
            if(user.getUserID().equals(userID)) {
                curU = user;
            }
        }
        return curU;
    }
    
    public User checkIfUserExist(String userID) {
        User curUser = getUser(userID);
        return curUser;
    }

    public Boolean add(User user) {
        return users.add(user);
    }

    public Integer validation(LoginForm loginForm) {
        for(User user : users) {
            if(user.getUsername().equals(loginForm.getUsername())){
                if (user.getPassword().equals(loginForm.getPassword())){
                    return 1;
                }
                return 0;
            }
        }
        return -1;
    }
}
