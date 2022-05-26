package com.example.homework.controllers;

import com.example.homework.model.User;
import com.example.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;
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
