package com.example.week2day4.controllers;

import com.example.week2day4.model.ResponseApi;
import com.example.week2day4.model.User;
import com.example.week2day4.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class userController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors error){
        if(error.hasFieldErrors()){
            String err_msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ResponseApi(err_msg,400));
        }
        if(!userService.addUser(user)){
            return ResponseEntity.status(400).body(new ResponseApi("User not added",400));
        }
        return ResponseEntity.status(201).body(new ResponseApi("User  added",201));
    }
}
