package com.example.cardealership.Controllers;

import com.example.cardealership.Models.Api;
import com.example.cardealership.Models.Car;
import com.example.cardealership.Services.CarService;
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
@PostMapping
    public ResponseEntity<Api> addCar(@RequestBody @Valid Car car , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

    if(!(carService.isAdd(car))) {
        return ResponseEntity.status(400).body(new Api("This car is already exit", 400));
    }return ResponseEntity.status(200).body(new Api("Added new car",200));


}

@GetMapping("/purchasedCar/{carid}/{userid}")
public ResponseEntity<Car> purchas(@PathVariable String carid,@PathVariable String userid){
     Car purchasedCar=carService.purchase(carid,userid);
       if(purchasedCar==null)
     return ResponseEntity.status(400).body(purchasedCar);
    return ResponseEntity.status(200).body(purchasedCar);



}


    @GetMapping("/resell/{carid}/{userid}")
    public ResponseEntity<Car> resell(@PathVariable String carid,@PathVariable String userid){
        Car resellCar=carService.resell(carid,userid);
        if(resellCar==null)
            return ResponseEntity.status(400).body(resellCar);
        return ResponseEntity.status(200).body(resellCar);



    }



}
