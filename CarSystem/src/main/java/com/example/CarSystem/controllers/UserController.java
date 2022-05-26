package com.example.CarSystem.controllers;

import com.example.CarSystem.models.Api;
import com.example.CarSystem.models.Car;
import com.example.CarSystem.models.Order;
import com.example.CarSystem.models.User;
import com.example.CarSystem.services.OrderServices;
import com.example.CarSystem.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userService ;
    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUserAdded= userService.addUser(user);

        if(!isUserAdded){
            return ResponseEntity.status(500).body("Server error !");
        }

        return ResponseEntity.status(200).body("New user added !");
    }
}
