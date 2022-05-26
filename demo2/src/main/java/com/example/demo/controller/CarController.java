package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.model.CarType;
import com.example.demo.model.ResponseAPI;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/car")
public class CarController {

    ArrayList<Car> cars = new ArrayList<>();
    private  final CarService carService;
    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCars());
    }
    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()){
            ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        carService.addCar(car);
        return ResponseEntity.status(200).body(new ResponseAPI("Car added",200));
    }
    @GetMapping("/cartype")
    public ResponseEntity listCarByType(@RequestBody @Valid CarType carType,Errors errors){
        if(errors.hasErrors()){
            ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        ArrayList<Car> type =  carService.listCarByType(carType);
        return ResponseEntity.status(200).body(type);
    }
    @PutMapping("/purchase/")
    public ResponseEntity buyCar(@RequestParam String carID, @RequestParam String userID){
        Integer carSold = carService.buyCar(carID,userID);
        return switch (carSold) {
            case -1 -> ResponseEntity.status(400).body(new ResponseAPI("car not found", 400));
            case 0 -> ResponseEntity.status(400).body(new ResponseAPI("user not found", 400));
            case 1 ->
                    ResponseEntity.status(400).body(new ResponseAPI("Balance isn't enough to make this purchase", 400));
            case 2 -> ResponseEntity.status(200).body(new ResponseAPI("Car Sold!", 200));
            default -> ResponseEntity.status(500).body(new ResponseAPI("Server error", 500));
        };
    }
    @PutMapping("/sell")
    public ResponseEntity sellCar(@RequestParam String carID, @RequestParam String userID){
        Integer carSold = carService.sellCar(carID,userID);
        return switch (carSold) {
            case -1 -> ResponseEntity.status(400).body(new ResponseAPI("car not found", 400));
            case 0 -> ResponseEntity.status(400).body(new ResponseAPI("user not found", 400));
            case 1 ->
                    ResponseEntity.status(400).body(new ResponseAPI("Balance isn't enough to make this purchase", 400));
            case 2 -> ResponseEntity.status(200).body(new ResponseAPI("Car Sold!", 200));
            default -> ResponseEntity.status(500).body(new ResponseAPI("Server error", 500));
        };
    }
}
