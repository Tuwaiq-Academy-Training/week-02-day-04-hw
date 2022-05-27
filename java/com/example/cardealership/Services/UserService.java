package com.example.cardealership.Services;

import com.example.cardealership.Models.Car;
import com.example.cardealership.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CarService carService;

    private ArrayList<User> users=new ArrayList<>();

    public boolean isAdd( User user){
        for (int i=0; i<users.size(); i++) {
            if(users.get(i).getUserid().equals(user.getUserid()))
                return false;
        }
        users.add(user);
        return true;
    }

    public ArrayList<User> getUser() {
        return users;
    }

    public User getUserByid(String userid) {
        for (User user:users ) {
            if (userid.equals(user.getUserid()))
                return user;
        }
        return null;
    }


}




