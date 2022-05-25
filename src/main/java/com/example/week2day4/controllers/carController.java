package com.example.week2day4.controllers;


import com.example.week2day4.model.Car;
import com.example.week2day4.model.ResponseApi;
import com.example.week2day4.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class carController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity getCars(){
        return ResponseEntity.status(200).body(carService.getCars());

    }

    @PostMapping
    public ResponseEntity addCars(@RequestBody @Valid Car car, Errors error){
        if(error.hasFieldErrors()){
            String err_msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ResponseApi(err_msg,400));
        }
        if(!carService.addCar(car)){
            return ResponseEntity.status(400).body(new ResponseApi("Car not added",400));

        }
    return ResponseEntity.status(201).body(new ResponseApi("Car Added",201));
    }

    @GetMapping("/list/{type}")
    public ResponseEntity listCar(@PathVariable String type){

        return ResponseEntity.status(200).body(carService.getCarByType(type));
    }

    @PutMapping("purchase/{carId}/{userId}")
    public ResponseEntity makePurchase(@PathVariable String carId,@PathVariable String userId){
        Integer buyStatus= carService.makePurchase(carId,userId);
        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new ResponseApi("Invalid car or user id",400));
            case 0:
                return ResponseEntity.status(400).body(new ResponseApi("Balance is not enough",400));
            case 1:
                return ResponseEntity.status(400).body(new ResponseApi("No enough stock available",400));
            case 2:
                return ResponseEntity.status(201).body(new ResponseApi("Car has successfully been purchased",201));
            default:
                return ResponseEntity.status(500).body(new ResponseApi("Error",500));

        }
    }
    @PutMapping("resell")
    public ResponseEntity sellCar(@RequestParam String carId,@RequestParam String userId){
        Boolean sellStatus= carService.sellCar(carId,userId);
        if(!sellStatus){
            return ResponseEntity.status(400).body(new ResponseApi("Invalid car or user id",400));

        }

        return ResponseEntity.status(201).body(new ResponseApi("Car has successfully been sold",201));

    }
}
