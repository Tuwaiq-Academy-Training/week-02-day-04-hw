package com.example.carmanagment.controller;

import com.example.carmanagment.model.Car;
import com.example.carmanagment.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

     @GetMapping
     public ResponseEntity<ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCars());
     }

    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type){
        ArrayList<Car> CarsByType=carService.getCarsByType(type);
        return ResponseEntity.status(200).body(CarsByType);
    }
    @PostMapping("/purchased")
    public ResponseEntity<String> purchasedCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.purchasedCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(400).body("User id or car id is wrong");
            case 0:
                return ResponseEntity.status(400).body("Sorry but your don't have money :(");
            case 1:
                return ResponseEntity.status(400).body("There is no car available :(");
            case 2:
                return ResponseEntity.status(200).body("car purchased :)");
            default:
                return ResponseEntity.status(500).body("Server Error! :)");
        }
    }


    @PostMapping("/sell")
    public ResponseEntity<String> sellCar(@RequestParam String userid,@RequestParam String carid){
        Integer carCase=carService.sellaCar(userid,carid);
        switch (carCase){
            case -1:
                return ResponseEntity.status(400).body("User id or car id is wrong");
            case 0:
                return ResponseEntity.status(400).body("You dont own the car :(");
            case 1:
                return ResponseEntity.status(200).body("Car Sold!");
            default:
                return ResponseEntity.status(500).body("Server Error! :)");
        }
    }
     @PostMapping
    public ResponseEntity<Api> addCar(@RequestBody @Valid Car car,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isAddCar = carService.addCar(car);
        if (!isAddCar){
            return ResponseEntity.status(400).body(new Api("Relly Sorry about that :(",400));
        }
         return ResponseEntity.status(200).body(new Api("Add a Car to the list :)",200));
     }
}
