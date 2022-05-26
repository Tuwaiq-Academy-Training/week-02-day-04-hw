package com.example.cardealershipmanagementsystem.controller;


import com.example.cardealershipmanagementsystem.models.Api;
import com.example.cardealershipmanagementsystem.models.Car;
import com.example.cardealershipmanagementsystem.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {


    private final  CarService carService;

//    public CarController(CarService carService){
//        this.carService=carService;
//    }

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCars());
    }

    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type){
        ArrayList<Car> carsByType=carService.getCarsByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(carsByType);
    }

    @PostMapping
    public ResponseEntity<String> addCars(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isCarAdded=carService.addCar(car);

        if(!isCarAdded){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("New card added !");
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.purchaseCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't have enough money for the car");
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no car available to buy");
            case 2:
                return ResponseEntity.status(HttpStatus.OK).body("Car purchased !");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }
    @PostMapping("/sell")
    public ResponseEntity<String> sellCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.sellaCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't own this car !");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Car sold !");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }
}