package com.example.springd4hw.services;

import com.example.springd4hw.model.Car;
import com.example.springd4hw.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

  //  private final CarService carService;
    private ArrayList<User> users=new ArrayList();

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean addUsres(User user){
        return users.add(user);
    }

    public User getUser(String userid){
        for (User user:users) {
            if(user.getId().equals(userid)){
                return user;
            }
        }
        return null;
    }
}
