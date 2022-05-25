package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.model.LoginForm;
import com.example.carmanagementsystem.model.ResponseAPI;
import com.example.carmanagementsystem.model.User;
import com.example.carmanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<ResponseAPI> register(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!authService.register(user)){
            return ResponseEntity.status(400).body(new ResponseAPI("user is already registered!",400));
        }
        return ResponseEntity.status(201).body(new ResponseAPI("user registered successfully!",201));
    }

    @PutMapping("/login")
    public ResponseEntity<ResponseAPI> login(@RequestBody LoginForm loginForm, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!authService.login(loginForm)){
            return ResponseEntity.status(400).body(new ResponseAPI("username or password is wrong!",400));
        }
        return ResponseEntity.status(200).body(new ResponseAPI("welcome back!",200));
    }



}
