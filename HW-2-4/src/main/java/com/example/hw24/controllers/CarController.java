package com.example.hw24.controllers;

import com.example.hw24.model.Api;
import com.example.hw24.model.Car;
import com.example.hw24.model.User;
import com.example.hw24.service.CarService;
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

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCar());
    }
    @PostMapping
    public ResponseEntity<Api> addCar(@RequestBody @Valid Car car, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isUserAdd = carService.addCar(car);
        if (!isUserAdd) {
            return ResponseEntity.status(500).body(new Api("Error adding a Car", 500));

        }
        return ResponseEntity.status(200).body(new Api("New Car added", 200));
    }

    @PutMapping("{cartype}")
    public ResponseEntity<Api> cartype(@PathVariable String cartype) {
        ArrayList<Car> car=carService.carType(cartype);

        return ResponseEntity.status(200).body(new Api("The car type"+car,200));


    }
    @PutMapping("/buy")
    public ResponseEntity<Api> buyCar(@RequestParam String userid, @RequestParam String carid, @RequestParam Integer price){
        Integer buyStatus=carService.buyCar(userid,carid,price);

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new Api("Userid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new Api("car is not valid",400));
            case 1:
                return ResponseEntity.status(400).body(new Api("Price is not enough",400));
            case 2:
                return ResponseEntity.status(200).body(new Api("Car purchased !",200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error",500));
        }

    }
    @PutMapping("/resell")
    public ResponseEntity<Api> resellCar(@RequestParam String userid, @RequestParam String carid) {
        Integer resellStatus = carService.resell(userid, carid);

        switch (resellStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("Userid is not valid", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("car is not valid", 400));

            case 1:
                return ResponseEntity.status(200).body(new Api("Car resell !", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }

    }

}
