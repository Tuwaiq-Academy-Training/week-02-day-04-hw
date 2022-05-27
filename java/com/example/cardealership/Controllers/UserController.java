package com.example.cardealership.Controllers;

import com.example.cardealership.Models.Api;
import com.example.cardealership.Models.User;
import com.example.cardealership.Services.UserService;
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
    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        if(!(userService.isAdd(user))) {
            return ResponseEntity.status(400).body(new Api("This user is already exit", 400));
        }return ResponseEntity.status(200).body(new Api("Added user car",200));


    }


    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUser());


    }
}
