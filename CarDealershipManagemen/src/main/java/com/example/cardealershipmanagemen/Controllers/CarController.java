package com.example.cardealershipmanagemen.Controllers;

import com.example.cardealershipmanagemen.Models.Car;
import com.example.cardealershipmanagemen.Models.Log;
import com.example.cardealershipmanagemen.Service.CarService;
import com.example.cardealershipmanagemen.Service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {

    public final CarService carService;
    public final LogService logService;

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCar());
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody @Valid Car car, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

             return ResponseEntity.status(200).body(carService.addCar(car));
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> updateCar(@PathVariable int index,
                                            @RequestBody @Valid Car car,
                                            Errors errors){
        if(errors.hasErrors()){
            ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(carService.updateCar(index,car));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteCar(@PathVariable int index){
        return ResponseEntity.status(200).body(carService.deleteCar(index));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity getCarType(@PathVariable String type){
        ArrayList<Car> carType = carService.getCarType(type);
        if (carType == null){
           return ResponseEntity.status(400).body("Car type is empty !");
        }
           return ResponseEntity.status(200).body(carType);
    }

    @PutMapping("/purchase/{userID}/{carID}")
    public ResponseEntity<String> purchaseCar(@PathVariable String userID,@PathVariable String carID){
        int buyCarStatus = carService.purchaseCar(userID,carID);
        switch (buyCarStatus){
            case -2:
               return ResponseEntity.status(400).body("car id empty!");
            case -1:
               return ResponseEntity.status(400).body("user id empty!");
            case 0:
               return ResponseEntity.status(400).body("car is finish !");
            case 1:
               return ResponseEntity.status(400).body("user balance is not enough");
            case 2:
                return ResponseEntity.status(200).body("car buy completed !");
            default:
               return ResponseEntity.status(500).body("there is some error");
        }
    }
}
