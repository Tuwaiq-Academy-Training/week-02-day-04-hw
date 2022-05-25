package com.example.carmanagementsystem.controller;


import com.example.carmanagementsystem.model.Log;
import com.example.carmanagementsystem.model.Order;
import com.example.carmanagementsystem.model.ResponseAPI;
import com.example.carmanagementsystem.model.User;
import com.example.carmanagementsystem.service.CarService;
import com.example.carmanagementsystem.service.LogService;
import com.example.carmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping( "api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final CarService carService;
    private final LogService logService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PutMapping("/sellCar/{carid}/{userid}")
    public ResponseEntity<ResponseAPI> sellCar(@PathVariable String carid, @PathVariable String userid) {
        Integer resellCStatus = carService.resellCar(carid,userid);
        switch (resellCStatus) {
            case -1:
                return ResponseEntity.status(400).body(new ResponseAPI("carid doesn't exists!",400));
            case 0:
                return ResponseEntity.status(400).body(new ResponseAPI("userid doesn't exists!",400));
            case 1:
                logService.addLog(new Log(String.format("Car: %s has been re-sold by %s",carid,userid),new Order(carid,userid)));
                return ResponseEntity.status(400).body(new ResponseAPI("car is sold!",400));
        }

        return ResponseEntity.status(500).body(new ResponseAPI("Server Error", 500));
    }
}
