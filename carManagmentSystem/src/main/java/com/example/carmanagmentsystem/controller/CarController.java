package com.example.carmanagmentsystem.controller;
import com.example.carmanagmentsystem.model.Car;
import com.example.carmanagmentsystem.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping

    public ResponseEntity getAllCars(){
        return ResponseEntity.status(200).body(carService.getAllCars());
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody @Valid Car car , Errors error){
        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }

        if (!carService.addNewCars(car)){
            return ResponseEntity.status(400).body("Server error");
        }
        return ResponseEntity.status(201).body("Car has added!!");
    }

    @GetMapping("getcarbytype/{type}")
    public ResponseEntity getCarByType(@PathVariable String type){
        if (carService.getCarsByType(type)==null){
            return ResponseEntity.status(400).body("no car in this type!!");
        }
        return ResponseEntity.status(201).body(carService.getCarsByType(type));
    }




}
