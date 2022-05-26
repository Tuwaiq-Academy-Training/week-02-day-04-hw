package com.demo.Homework4.Controller;

import com.demo.Homework4.Model.User;
import com.demo.Homework4.Service.UserService;

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
    @GetMapping("/")
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUsers());

    }

    @PostMapping("/")
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user, Errors errors) {

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        boolean isUserAdded = userService.addUsers(user);

        if(!isUserAdded){
            return ResponseEntity.status(500).body(new Api("Error adding a user",500));
        }

        return ResponseEntity.status(200).body(new Api("New user added",200));
    }
}
