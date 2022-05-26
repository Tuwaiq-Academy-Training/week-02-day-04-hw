package com.example.springd4hw.controllers;

import com.example.springd4hw.services.CarService;
import com.example.springd4hw.model.Api;
import com.example.springd4hw.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {

        private final CarService carService;

        @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars(){
            return ResponseEntity.status(200).body(carService.getCars());
        }

        @PostMapping
    public ResponseEntity<Api> addCars(@RequestBody @Valid Car car, Errors errors){
            if(errors.hasErrors()){
                return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
            }
            boolean carAdded = carService.addCars(car);
            if(!carAdded){
                return ResponseEntity.status(500).body(new Api("Error adding a car",500));
            }
            return ResponseEntity.status(200).body(new Api("New car adding ",200));
        }


    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> carByType(@PathVariable String type) {
        ArrayList<Car> carByType = carService.carsByType(type);
            return ResponseEntity.status(200).body(carByType);
    }

    @PostMapping("/buycar")
    public ResponseEntity<Api> buyCar(@RequestParam String carid,@RequestParam String userid){

            Integer buyStatus=carService.buyCar(carid, userid);

            switch (buyStatus){
                case -1:
                    return ResponseEntity.status(400).body(new Api("User id is not found",400));
                case 0:
                    return ResponseEntity.status(400).body(new Api("Car id is not found",400));
                case 1:
                    return ResponseEntity.status(400).body(new Api("Your balance is not enough :) ",400));
                case 2:
                    return ResponseEntity.status(201).body(new Api("Congratulations on your new car <3 ",400));
                default:
                    return ResponseEntity.status(500).body(new Api("Server error",500));
            }
    }

    @PostMapping("/sell")
    public ResponseEntity<Api> sellCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.sellaCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(400).body(new Api("User id or card id is wrong",400));
            case 0:
                return ResponseEntity.status(400).body(new Api("You don't own this car !",400));
            case 1:
                return ResponseEntity.status(200).body(new Api("Car sold !",200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error !",500));
        }
    }
}
