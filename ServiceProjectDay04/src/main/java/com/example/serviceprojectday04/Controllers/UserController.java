package com.example.serviceprojectday04.Controllers;

import com.example.serviceprojectday04.models.Api;
import com.example.serviceprojectday04.models.User;
import com.example.serviceprojectday04.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/")
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isUserAdded = userService.addUser(user);

        if (!isUserAdded) {
            return ResponseEntity.status(500).body(new Api("Error adding a user", 500));

        }

        return ResponseEntity.status(200).body(new Api("New user added", 200));
    }
    @PutMapping("/purchase")
    public ResponseEntity purchaseCar(@RequestParam String userid,@RequestParam String carId){
        Integer purchaseStatus = userService.purchaseCar(userid, carId);
        switch (purchaseStatus){
            case 0:
                return ResponseEntity.status(200).body(new Api("Successfully bought!", 200));
            case -1:
                return ResponseEntity.status(400).body(new Api("Car id is incorrect", 400));
            case 1:
                return ResponseEntity.status(400).body(new Api("user id is wrong", 400));
            case 2:
                return ResponseEntity.status(400).body(new Api("No enough funds", 400));
            default:
                return ResponseEntity.status(400).body(new Api("Unknown Error", 400));
        }
    }
    @PutMapping("/resell")
    public ResponseEntity resellCar(@RequestParam String userid,@RequestParam String carId){
        Integer resaleStatus = userService.purchaseCar(userid, carId);
        switch (resaleStatus){
            case 0:
                return ResponseEntity.status(200).body(new Api("Successfully Sold!", 200));
            case -1:
                return ResponseEntity.status(400).body(new Api("Car id is incorrect", 400));
            case 1:
                return ResponseEntity.status(400).body(new Api("user id is wrong", 400));
            case 2:
                return ResponseEntity.status(400).body(new Api("You don't own that car", 400));
            default:
                return ResponseEntity.status(404).body(new Api("Unknown Error", 404));
        }
    }
}