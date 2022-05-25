package com.example.hw24.controllers;

import com.example.hw24.model.Api;
import com.example.hw24.model.User;
import com.example.hw24.service.UserService;
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
    public ResponseEntity<ArrayList<User>> getUser() {

        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isUserAdd = userService.addUser(user);
        if (!isUserAdd) {
            return ResponseEntity.status(500).body(new Api("Error adding a User", 500));

        }
        return ResponseEntity.status(200).body(new Api("New User added", 200));
    }


}
