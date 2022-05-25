package com.example.carmanagmentsystem.service;

import com.example.carmanagmentsystem.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserService {

    @NonNull private final LogService logService;
    private ArrayList<User> users=new ArrayList();

    public ArrayList<User> getUsers(){
        return  users;
    }

    public boolean addUser(User user) {
        logService.addLog(user.getUsername()+ " has been registered ");
        return users.add(user);
    }

}
