package com.example.cardealershipmanagemen.Controllers;

import com.example.cardealershipmanagemen.Models.Car;
import com.example.cardealershipmanagemen.Models.User;
import com.example.cardealershipmanagemen.Service.CarService;
import com.example.cardealershipmanagemen.Service.UserService;
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
    public final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        return ResponseEntity.status(200).body(userService.addUser(user));
    }
}
