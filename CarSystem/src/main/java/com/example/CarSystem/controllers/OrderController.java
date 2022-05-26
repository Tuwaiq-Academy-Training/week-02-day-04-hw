package com.example.CarSystem.controllers;

import com.example.CarSystem.models.Car;
import com.example.CarSystem.models.Order;
import com.example.CarSystem.services.CarServices;
import com.example.CarSystem.services.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

}
