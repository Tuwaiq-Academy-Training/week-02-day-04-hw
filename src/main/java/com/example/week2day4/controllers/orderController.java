package com.example.week2day4.controllers;

import com.example.week2day4.model.Order;
import com.example.week2day4.model.ResponseApi;
import com.example.week2day4.services.LogService;
import com.example.week2day4.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class orderController {
    private final OrderService orderService;


@GetMapping
    public ResponseEntity getOrders(){
    return ResponseEntity.status(200).body(orderService.getOrders());
}
@PostMapping
public ResponseEntity addOrder(@RequestBody @Valid Order order, Errors error){
 if(error.hasFieldErrors()){
     String err_msg=error.getFieldError().getDefaultMessage();
     return ResponseEntity.status(400).body(new ResponseApi(err_msg,400));
 }
 Boolean orderStatus= orderService.addOrder(order);
 if(!orderStatus){
     return ResponseEntity.status(400).body(new ResponseApi("Order not placed",400));
 }

 return ResponseEntity.status(201).body(new ResponseApi("Order placed",201));
}


}
