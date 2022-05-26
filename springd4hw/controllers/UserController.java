package com.example.springd4hw.controllers;

import com.example.springd4hw.model.Api;
import com.example.springd4hw.model.Car;
import com.example.springd4hw.model.User;
import com.example.springd4hw.services.CarService;
import com.example.springd4hw.services.LogService;
import com.example.springd4hw.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;
        private final CarService carService;
        private final LogService logService;

        @GetMapping
    public ResponseEntity<ArrayList<User>> getUsers(){
            return ResponseEntity.status(200).body(userService.getUsers());
        }

        @PostMapping
    public ResponseEntity<Api> addUsers(@RequestBody @Valid User user, Errors errors){
            if(errors.hasErrors()){
                return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
            }
            boolean userAdded = userService.addUsres(user);
            if(!userAdded){
                return ResponseEntity.status(500).body(new Api("Error adding a user",500));
            }
            return ResponseEntity.status(200).body(new Api("New user adding ",200));
        }




}
