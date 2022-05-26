package com.example.cardealershipmanagementsystem.controller;

import com.example.cardealershipmanagementsystem.models.Api;
import com.example.cardealershipmanagementsystem.models.Car;
import com.example.cardealershipmanagementsystem.models.Log;
import com.example.cardealershipmanagementsystem.models.Order;
import com.example.cardealershipmanagementsystem.service.OrderService;
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
    public ResponseEntity<ArrayList<Order>> getOrder(){
        return ResponseEntity.status(200).body(orderService.getOrder());
    }

    @PostMapping
    public ResponseEntity<Api> addOrder(@RequestBody @Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        boolean isAddOrder = orderService.addOrder(order);
        if (!isAddOrder) {
            return ResponseEntity.status(500).body(new Api("Error", 500));
        }
        return ResponseEntity.status(200).body(new Api("New car added", 200));
    }
}
