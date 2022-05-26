package com.example.carmanagmentsystem.controller;


import com.example.carmanagmentsystem.service.LogService;
import com.example.carmanagmentsystem.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final LogService logService;

    @PutMapping("purchasecar/{userid}/{carid}")
    public ResponseEntity purchaseCar(@PathVariable String userid , @PathVariable  String carid){

        if (!orderService.purchaseCar(carid,userid)){
            return ResponseEntity.status(400).body(" XXXX invalid purchase XXXX");
        }
        return ResponseEntity.status(201).body(" Wohoo!! you have new car!!!");
    }

    @PutMapping("resellcar/{userid}/{carid}")
    public ResponseEntity resSellCar(@PathVariable String userid , @PathVariable  String carid){
        if (!orderService.reSellCar(carid,userid)){
            return ResponseEntity.status(400).body(" XXXX invalid re-sell XXXX");
        }
        return ResponseEntity.status(201).body(" Wohoo!! you have re-sell your car!!!");
    }

}
