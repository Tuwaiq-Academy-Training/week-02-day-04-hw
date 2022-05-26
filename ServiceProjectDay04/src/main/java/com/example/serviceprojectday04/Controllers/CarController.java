package com.example.serviceprojectday04.Controllers;

import com.example.serviceprojectday04.models.Api;
import com.example.serviceprojectday04.models.Car;
import com.example.serviceprojectday04.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @AllArgsConstructor @RequestMapping("api/v1/car")
public class CarController {
    private CarService carService;
    @GetMapping("/")
    public ResponseEntity getCars(){
        return ResponseEntity.status(200).body(carService.getCars());
    }
    @GetMapping("/{id}")
    public ResponseEntity getCarsByType(String id){
       return ResponseEntity.status(200).body(carService.getCarsByType());
    }
    @PostMapping("/")
    public ResponseEntity addCar(@RequestBody @Valid Car car, Errors error){
        if (error.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(error.getFieldError().getDefaultMessage(), 400));
        }
        carService.addCar(car);
            return ResponseEntity.status(400).body(new Api("Successfully added.", 200));
    }
}
