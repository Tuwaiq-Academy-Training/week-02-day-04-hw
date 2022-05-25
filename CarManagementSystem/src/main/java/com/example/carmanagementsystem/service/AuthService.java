package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.model.LoginForm;
import com.example.carmanagementsystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    public Boolean register(User user) {
        if(userService.checkIfUserExist(user.getUserID()) == null) {
            return false;
        }

        return userService.add(user);
    }

    public boolean login(LoginForm loginForm) {
        Integer loginCase = userService.validation(loginForm);
        if(loginCase == -1 || loginCase == 0) {
            return false;
        } else if (loginCase == 1) {
          return true;
        }
        return false;
    }
}
