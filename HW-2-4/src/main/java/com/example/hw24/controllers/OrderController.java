package com.example.hw24.controllers;

import com.example.hw24.model.Api;
import com.example.hw24.model.Order;
import com.example.hw24.service.OrderService;
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

    @GetMapping
    public ResponseEntity<ArrayList<Order>> getOrder(){

        return ResponseEntity.status(200).body(orderService.getOrder());
    }
    @PostMapping
    public ResponseEntity<Api> addOrder(@RequestBody @Valid Order order, Errors errors) {

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        boolean isOrdd=orderService.addOrder(order);
        if(!isOrdd){
            return ResponseEntity.status(500).body(new Api("Error adding a order",500));

        }
        return ResponseEntity.status(200).body(new Api("New order added",200));
    }
}
