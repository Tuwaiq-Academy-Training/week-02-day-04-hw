package com.example.cardealership.controllers;

import com.example.cardealership.model.Api;
import com.example.cardealership.model.Order;
import com.example.cardealership.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Get all the domain data.
     */
    @GetMapping()
    public ResponseEntity<List> getOrder() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
    }
    /**
     * Get a specific data by passing an id.
     *
     * @param id id of the data
     */
    @GetMapping("{id}")
    ResponseEntity<Object> getOrderByID(@PathVariable String id) {
        if (!orderService.isOrderByID(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("Not Found, no ride with that id", HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(id));
    }

    @PostMapping ("/purchase")
    ResponseEntity<Api> purchase(@RequestBody @Valid Order p, Errors errors) {
        try {
            check(errors);
            return (orderService.purchaseCar(p)) ? ResponseEntity.status(HttpStatus.CREATED).body(new Api("car purchased successfully!", HttpStatus.CREATED)) :
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("purchase was NOT successful!!", HttpStatus.INTERNAL_SERVER_ERROR));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
    @PostMapping ("/resell")
    ResponseEntity<Api> resell(@RequestBody @Valid Order p, Errors errors) {
        try {
            check(errors);
            return (orderService.resellCar(p)) ? ResponseEntity.status(HttpStatus.CREATED).body(new Api("car resold successfully!", HttpStatus.CREATED)) :
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("resell was NOT successful!!", HttpStatus.INTERNAL_SERVER_ERROR));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    /**
     * Delete a data by passing an id.
     *
     * @param id id of the data
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Api> deleteOrder(@PathVariable String id) {
        boolean status;
        status = orderService.deleteOrder(id);
        return (!status) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("No data found!", HttpStatus.BAD_REQUEST))
                : ResponseEntity.status(HttpStatus.OK).body(new Api("Successfully deleted!", HttpStatus.OK));
    }

    public void check(Errors errors) throws IllegalArgumentException {
        if (errors.hasErrors()) {
            String error = errors.getFieldError().getDefaultMessage();
            throw new IllegalArgumentException(error);
        }
    }
}
