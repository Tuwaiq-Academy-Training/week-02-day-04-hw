package com.example.cardealershipproj.Controllers;


import com.example.cardealershipproj.models.Api;
import com.example.cardealershipproj.models.Car;
import com.example.cardealershipproj.services.CarServices;
import com.example.cardealershipproj.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor // lombook made a constructor for Car service (Dependency injection)
public class CarController {


    private final CarServices carServices;
    // injecton
    private final UserServices userServices;

    // get all the cars
    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars(){
        return ResponseEntity.status(200).body(carServices.getCars());
    }

    // adding a car

    @PostMapping
    public ResponseEntity<Api> addCar(@RequestBody @Valid Car car , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage() , 400));
        }
        Boolean isCarAdded = carServices.addCar(car);
        if(!isCarAdded){
             // is server error cuz we adding the book
            return ResponseEntity.status(500).body(new Api("error adding a car",500));
        }

        return ResponseEntity.status(200).body(new Api("new car is added",200));
    }



    @PutMapping("/purchase")
    public ResponseEntity<Api> buyCar(@RequestParam String carId ,
                                      @RequestParam String userId ){

        Integer purchaseStatus = carServices.buyCar(carId , userId );
        return switch (purchaseStatus) {
            case -2 -> ResponseEntity.status(200).body(new Api("your balnace is enough to buy a car", 200));
            case -1 -> ResponseEntity.status(400).body(new Api("the user  not exist please register!!", 400));
            case 0 -> ResponseEntity.status(400).body(new Api("the car is not exist", 400));
            case 1 -> ResponseEntity.status(200).body(new Api("still dont know what is thattt?", 200));
            default -> ResponseEntity.status(500).body(new Api("server error !!", 500));
        };
    }

    //list a t car by type like get endpoint no error unless request body

    @GetMapping("/type")

    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type){ // should be the same name of the route(type)
        ArrayList<Car> carByType = carServices.getCarsByType(type);
        return ResponseEntity.status(200).body( carByType);
    }

    @PostMapping("/sell")
    public ResponseEntity<Api> sellCar(@RequestParam String userId , @RequestParam String carId){
             Integer carCase = carServices.sellCar(userId , carId);
        return switch (carCase) {
            case -1 ->
                // we should not tell which one is wrong
                // for more security
                    ResponseEntity.status(400).body(new Api("problem w userid or carid", 400));
            case 0 -> ResponseEntity.status(400).body(new Api("you do not own this car", 400));
            case 1 -> ResponseEntity.status(200).body(new Api("Sale completed", 200));
            default -> ResponseEntity.status(500).body(new Api("Server Error", 500));
        };
    }


}
