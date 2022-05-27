package com.example.cardealership.Controllers;

import com.example.cardealership.Models.Api;
import com.example.cardealership.Models.Order;
import com.example.cardealership.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid Order order , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        if(!(orderService.isAdd(order))) {
            return ResponseEntity.status(400).body(new Api("This order is already exit", 400));
        }return ResponseEntity.status(200).body(new Api("Added order",200));


    }


    @GetMapping
    public ResponseEntity<ArrayList<Order>> getorder(){
        return ResponseEntity.status(200).body(orderService.getOrders());


    }
}
