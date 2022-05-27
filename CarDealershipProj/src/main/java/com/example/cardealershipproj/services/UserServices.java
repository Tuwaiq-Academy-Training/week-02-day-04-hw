package com.example.cardealershipproj.services;

import com.example.cardealershipproj.models.Car;
import com.example.cardealershipproj.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserServices {


    ArrayList<User> users = new ArrayList();
    public ArrayList<User> getUsers() {
        return users;
    }

    public Boolean addCarOwned(User user) {
        return users.add(user);

    }


    public Boolean addUser(User user){
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

