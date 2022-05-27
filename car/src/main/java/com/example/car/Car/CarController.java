package com.example.car.Car;

import com.example.car.Logs.Logs;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    //Get
    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars() {
        return ResponseEntity.status(200).body(carService.getCars());
    }

    @GetMapping("{type}")
    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type) {
        ArrayList<Car> carByType = carService.getCarsByType(type);
        return ResponseEntity.status(200).body(carByType);

    }

    //ADD
    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody @Valid Car car, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Error");
        }

        boolean isCarAdded = carService.addCar(car);
        if (!isCarAdded) {
            return ResponseEntity.status(400).body("ERROR adding a car");
        }

        return ResponseEntity.status(200).body("New car added");

    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseCar(@RequestParam String userid, @RequestParam String carid, Errors errors) {
        Integer careCase = carService.purchaseCar(carid, userid);
        switch (careCase) {
            case -1:

                return ResponseEntity.status(400).body("userid or carid is null");

        case 0:
        return ResponseEntity.status(400).body("Balance is less than car price");

        case 1:
                return ResponseEntity.status(400).body("There is no car available to buy");

            case 2:
                return ResponseEntity.status(200).body("Car purchased!");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error!");


        }}
    @PostMapping("/sell")
    public ResponseEntity<String> sellCar(@RequestParam String userid, @RequestParam String carid, Errors errors) {
        Integer careCase = carService.sellCar(carid, userid);
        switch (careCase) {
            case -1:

                return ResponseEntity.status(400).body("userid or carid is null");

            case 0:
                return ResponseEntity.status(400).body("You dont own this car");

            case 1:
                return ResponseEntity.status(400).body("There is no car available to buy");

            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error!");




        }





}}
