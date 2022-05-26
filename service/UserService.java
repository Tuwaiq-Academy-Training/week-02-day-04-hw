package com.example.carmanagment.service;

import com.example.carmanagment.model.Car;
import com.example.carmanagment.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
   private ArrayList<User> users = new ArrayList<>();

   public ArrayList<User> getUser(){
      return getUser();
   }
   public boolean addUser(User newUser){
     return users.add(newUser);
   }

    public User getUsers(String userid) {
        for (User user:users) {
            if (user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }
}
