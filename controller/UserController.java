package com.example.carmanagment.controller;

import com.example.carmanagment.model.Car;
import com.example.carmanagment.model.User;
import com.example.carmanagment.service.CarService;
import com.example.carmanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }
    @PostMapping ResponseEntity<Api> addCar(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api("Error request Invalid :(",400));
        }
        boolean isUserAdded = userService.addUser(user);
        if (!isUserAdded){
            return ResponseEntity.status(400).body(new Api("Error Add user request Invalid :(",400));
        }
        return ResponseEntity.status(201).body(new Api("Add user request Valid :)",201));
    }

}
