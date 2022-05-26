package com.example.assignment8.controller;

import com.example.assignment8.model.Api;
import com.example.assignment8.model.User;
import com.example.assignment8.service.UserService;
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

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Api> addUsers(@RequestBody @Valid User user,
                                        Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isUserAdded = userService.addUsers(user);
        if(!isUserAdded){
            return ResponseEntity.status(500).body(new Api("Error to adding user",500));
        }
        return ResponseEntity.status(200).body(new Api("The user added",200));
    }



}
