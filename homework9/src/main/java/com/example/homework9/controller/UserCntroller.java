package com.example.homework9.controller;
import com.example.homework9.model.ResponseApi;
import com.example.homework9.model.Users;
import com.example.homework9.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController

@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserCntroller {
    private final UserServices userServices;

    @GetMapping
    public ResponseEntity<ArrayList<Users>> getUser(){
        return ResponseEntity.status(200).body(userServices.getUser());}

    @PostMapping
    public ResponseEntity<ResponseApi> addUser(@RequestBody @Valid Users user, Errors errors) {

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseApi(errors.getFieldError().getDefaultMessage(),400));}

        boolean isCarAdded=userServices.addUser(user);
        if(!isCarAdded){
            return ResponseEntity.status(500).body(new ResponseApi("Error in adding a Car",500));}

        return ResponseEntity.status(200).body(new ResponseApi("New car added now",200));
    }
}
