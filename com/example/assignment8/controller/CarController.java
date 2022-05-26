package com.example.assignment8.controller;

import com.example.assignment8.model.Api;
import com.example.assignment8.model.Car;
import com.example.assignment8.service.CarService;
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
    public ResponseEntity<ArrayList<Car>> getCars() {

        return ResponseEntity.status(200).body(carService.getCars());
    }

    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type) {
        return ResponseEntity.status(200).body(carService.getCars());
    }

    @PostMapping
    public ResponseEntity<Api> addCars(@RequestBody @Valid Car car, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAddCars = carService.addCars(car);
        if (!isAddCars) {
            return ResponseEntity.status(500).body(new Api("Error to adding car", 500));
        }
        return ResponseEntity.status(200).body(new Api("The user added", 200));
    }

    @PostMapping("/buy")
    public ResponseEntity<Api> buyCar(@RequestParam String carId, @RequestParam String userid) {

        Integer buyStatus = carService.buyCar(carId, userid);
        switch (buyStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("UserId is not valid", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("CarId is not valid", 400));
            case 1:
                return ResponseEntity.status(400).body(new Api("Balance is not enough", 400));
            case 2:
                return ResponseEntity.status(200).body(new Api("Car purchased", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }

        @PutMapping("/resell")
        public ResponseEntity<Api> resellCar(@RequestParam String carId, @RequestParam String userid) {

            Integer resellStatus = carService.resellCar(carId, userid);
            switch (resellStatus) {
                case -1:
                    return ResponseEntity.status(400).body(new Api("UserId is not valid", 400));
                case 0:
                    return ResponseEntity.status(400).body(new Api("CarId is not valid", 400));
                case 1:
                    return ResponseEntity.status(400).body(new Api("Car is sold", 400));
                case 2:
                    return ResponseEntity.status(200).body(new Api("Car resell", 200));
                default:
                    return ResponseEntity.status(500).body(new Api("Server error", 500));
            }

    }
}
