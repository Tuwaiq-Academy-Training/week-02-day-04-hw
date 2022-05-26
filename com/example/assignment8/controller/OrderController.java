package com.example.assignment8.controller;

import com.example.assignment8.model.Api;
import com.example.assignment8.model.Order;
import com.example.assignment8.service.OrderService;
import com.example.assignment8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<ArrayList<Order>> getOrders(){
        return ResponseEntity.status(200).body(orderService.getOrders());
    }

    @PostMapping
    public ResponseEntity<Api> addOrder(@RequestBody @Valid Order order, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        boolean isOrderAdded = orderService.addOrder(order);
        if(!isOrderAdded){
            return ResponseEntity.status(400).body(new Api("Invalid order",400));
        }
        return ResponseEntity.status(201).body(new Api("New order added",201));
    }
}
