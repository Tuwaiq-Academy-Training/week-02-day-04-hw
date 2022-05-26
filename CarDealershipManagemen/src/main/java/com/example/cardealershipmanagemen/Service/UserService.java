package com.example.cardealershipmanagemen.Service;

import com.example.cardealershipmanagemen.Models.Car;
import com.example.cardealershipmanagemen.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<User> getUser() {
        return users;
    }

    public String addUser(User user) {
        users.add(user);
        return "add user";
    }
    public User checkUser(String carID){
        for (User user: users){
            if (user.getId().equals(carID)){
                return user;
            }
        }
        return null;
    }
}
