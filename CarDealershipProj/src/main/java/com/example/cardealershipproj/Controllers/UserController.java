package com.example.cardealershipproj.Controllers;


import com.example.cardealershipproj.models.Api;
import com.example.cardealershipproj.models.User;
import com.example.cardealershipproj.services.CarServices;
import com.example.cardealershipproj.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;

@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServices userServices;
    private final CarServices carServices;


    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userServices.getUsers());
    }


    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody  @Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        Boolean isUserAdded = userServices.addUser(user);
        if(!isUserAdded){
            return ResponseEntity.status(500).body(new Api("error adding a user" ,500));
        }

        return ResponseEntity.status(200).body(new Api("new user added", 200));

    }









}
