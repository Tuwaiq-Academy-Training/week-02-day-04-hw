package com.example.homework9.controller;

import com.example.homework9.model.Car;
import com.example.homework9.model.ResponseApi;
import com.example.homework9.services.CarServices;
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
    private final CarServices carServices;

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars(){
        return ResponseEntity.status(200).body(carServices.getCars());}

    @PostMapping
    public ResponseEntity<ResponseApi> addCar(@RequestBody @Valid Car car, Errors errors) {

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ResponseApi(errors.getFieldError().getDefaultMessage(),400));}

        boolean isCarAdded=carServices.addCar(car);
        if(!isCarAdded){
            return ResponseEntity.status(500).body(new ResponseApi("Error in adding a Car",500));}

        return ResponseEntity.status(200).body(new ResponseApi("New car added now",200));
    }

    @GetMapping({"/carbytybe/{type}"})
    public ResponseEntity getCarsbytybe(@PathVariable String type){
        return ResponseEntity.status(200).body(carServices.getCarby(type));}

    @PutMapping("/buy")
    public ResponseEntity<ResponseApi> buyCar(@RequestParam String userid,
                                       @RequestParam String carid,
                                       @RequestParam Integer price){

        Integer buyStatus=carServices.buyCar(userid,carid,price);

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new ResponseApi("User id is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new ResponseApi("car id is not valid",400));
            case 1:
                return ResponseEntity.status(400).body(new ResponseApi("Price is not enough",400));
            case 2:
                return ResponseEntity.status(200).body(new ResponseApi("balance is less than price!",200));
            case 3:
                return ResponseEntity.status(200).body(new ResponseApi("car purchased !",200));
                default:
                return ResponseEntity.status(500).body(new ResponseApi("Server error",500));
        }
    }
    @PutMapping("/resell")
    public ResponseEntity<ResponseApi> resellCar(@RequestParam String userid,
                                                 @RequestParam String carid,
                                                 @RequestParam Integer price) {
        Integer resellStatus = carServices.resellCar(userid, carid);
        switch (resellStatus) {
            case -1:
                return ResponseEntity.status(400).body(new ResponseApi("User id is not valid", 400));
            case 0:
                return ResponseEntity.status(400).body(new ResponseApi("car id is not valid", 400));
            case 1:
                return ResponseEntity.status(200).body(new ResponseApi("car resoled !", 200));
            default:
                return ResponseEntity.status(500).body(new ResponseApi("Server error", 500));
        }
    }
    }

