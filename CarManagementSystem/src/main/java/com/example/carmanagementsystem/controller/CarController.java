package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.model.Log;
import com.example.carmanagementsystem.model.Order;
import com.example.carmanagementsystem.model.ResponseAPI;
import com.example.carmanagementsystem.service.CarService;
import com.example.carmanagementsystem.service.LogService;
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
    private final CarService carService;
    private final LogService logService;

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars() {
        return ResponseEntity.status(200).body(carService.getCars());
    }

    @PostMapping
    public ResponseEntity<ResponseAPI> addCar(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        Integer isCarAdded = carService.addCar(car);
        if (isCarAdded == 1) {
            return ResponseEntity.status(500).body(new ResponseAPI("Car already registered!",500));
        }
        return ResponseEntity.status(201).body(new ResponseAPI("Car addded successfully!",201));
    }
    @PutMapping
    public ResponseEntity<ResponseAPI> editCar(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ResponseAPI(errors.getFieldError().getDefaultMessage(),400));
        }
        //look for car if there's add new
        boolean isCarAdded = carService.editCar(car);
        if (!isCarAdded) {
            return ResponseEntity.status(500).body(new ResponseAPI("Car doesn't exists!",500));
        }
        return ResponseEntity.status(201).body(new ResponseAPI("Car edited successfully!",201));
    }

    @GetMapping("/{carType}")
    public ResponseEntity<Object> getCarsByType(@PathVariable String carType) {
        ArrayList<Car> carsType = carService.getCarsByType(carType);
        if (carsType.size() == 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("carType doesn't exists!",400));
        }
        return ResponseEntity.status(200).body(carsType);
    }

    @PutMapping("/purchase/{carid}/{userid}")
    public ResponseEntity<ResponseAPI> purchaseCar(@PathVariable String carid, @PathVariable String userid) {
        Integer purchaseStatus = carService.purchaseCar(carid,userid);
        switch (purchaseStatus) {
            case -1:
                return ResponseEntity.status(400).body(new ResponseAPI("carid doesn't exists!",400));
            case 0:
                return ResponseEntity.status(400).body(new ResponseAPI("userid doesn't exists!",400));
            case 1:
                return ResponseEntity.status(400).body(new ResponseAPI("car is out of stock!",400));
            case 2:
                return ResponseEntity.status(200).body(new ResponseAPI("user balance is lower than car price!",200));
            case 3:
                logService.addLog(new Log(String.format("Car: %s has been sold to %s",carid,userid),new Order(carid,userid)));
                return ResponseEntity.status(200).body(new ResponseAPI("car purchased successfully!",200));
        }

        return ResponseEntity.status(500).body(new ResponseAPI("Server Error", 500));
    }


}
