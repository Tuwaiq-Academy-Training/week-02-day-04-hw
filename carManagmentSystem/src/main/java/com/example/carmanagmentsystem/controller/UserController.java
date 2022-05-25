package com.example.carmanagmentsystem.controller;
import com.example.carmanagmentsystem.model.User;
import com.example.carmanagmentsystem.service.LogService;
import com.example.carmanagmentsystem.service.UserService;
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
        public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
            if(errors.hasErrors()){
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }
            if(!userService.addUser(user)){
                return ResponseEntity.status(500).body(("Error adding a user"));
            }
            return ResponseEntity.status(200).body("New user added");
        }
    }

