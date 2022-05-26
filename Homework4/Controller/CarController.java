package com.demo.Homework4.Controller;

import com.demo.Homework4.Model.Car;
import com.demo.Homework4.Service.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    //Create endpoint to list all cars
    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCar());
    }

    //Create endpoint to list all cars
    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> getCarByType(@PathVariable String type){
        ArrayList<Car> carsByType = carService.getCarByType(type);
        return ResponseEntity.status(200).body(carsByType);
    }

    //Add
    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody @Valid Car car, Errors errors) {

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isCarAdded=carService.addCar(car);

        if(!isCarAdded){
            return ResponseEntity.status(500).body("Server error !");
        }

        return ResponseEntity.status(200).body("New card added !");
    }


    // Create endpoint that purchase a car by sending car id and the user id
    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase = carService.purchaseCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(500).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(500).body("No enough money to buy the car");
            case 1:
                return ResponseEntity.status(500).body("There is no car available to buy");
            case 2:
                return ResponseEntity.status(200).body("Car purchased !");
            default:
                return ResponseEntity.status(400).body("Server error !");
        }
    }


    //Create endpoint to resell the car that takes the car id
    @PostMapping("/sell")
    public ResponseEntity<String> sellCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.sellaCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(500).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(500).body("You don't own this car");
            case 1:
                return ResponseEntity.status(200).body("Car sold");
            default:
                return ResponseEntity.status(400).body("Server error");
        }
    }
}
