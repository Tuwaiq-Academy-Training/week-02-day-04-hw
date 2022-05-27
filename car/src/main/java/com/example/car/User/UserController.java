package com.example.car.User;

import com.example.car.Car.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    private final CarService carService;

    //Get
    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    //ADD
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()) {

            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
    boolean isUserAdded = userService.addUser(user);
        if (!isUserAdded){
            return ResponseEntity.status(400).body("ERROR adding a user");
        }

        return ResponseEntity.status(200).body("New user added");


    }




}
