package com.example.cardealership.controllers;

import com.example.cardealership.model.Api;
import com.example.cardealership.model.Car;
import com.example.cardealership.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }
    /**
     * Get all the domain data.
     */
    @GetMapping()
    public ResponseEntity<List> getCar(){
        return  ResponseEntity.status(HttpStatus.OK).body(carService.getCars());
    }
    /**
     * Get a specific data by passing an id.
     * @param id id of the data
     */
    @GetMapping("/{id}")
    ResponseEntity<Object> getCarByID(@PathVariable String id){
        if (!carService.isCarByID(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("Not Found, no ride with that id", HttpStatus.BAD_REQUEST));
        }
        return  ResponseEntity.status(HttpStatus.OK).body(carService.getById(id));
    }

    @GetMapping("type/{type}")
    ResponseEntity<Object> getCarByType(@PathVariable String type){
        type = type.toLowerCase(Locale.ROOT);
        if (type.equals("sedan") || type.equals("suv") || type.equals("truck")){
            return  ResponseEntity.status(HttpStatus.OK).body(carService.getByType(type));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("Not a valid car type!", HttpStatus.BAD_REQUEST));
    }

    /**
     * Add new data.
     * @param c date to be added
     * @param errors errors if any found from the date validation
     */
    @PostMapping()
    ResponseEntity<Api> addCar(@RequestBody @Valid Car c, Errors errors){
        try {
            check(errors);
            return (carService.addCar(c)) ? ResponseEntity.status(HttpStatus.CREATED).body(new Api("Adding was successful!", HttpStatus.CREATED)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("Adding was NOT successful!!", HttpStatus.INTERNAL_SERVER_ERROR));
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
    /**
     * Update/Create data by passing an id.
     * @param id id of the data
     */
    @PutMapping("{id}")
    public ResponseEntity<Api> putCar(@RequestBody @Valid Car p, Errors errors, @PathVariable String id){
        try {
            check(errors);
            Car car = carService.getById(id);
            if (car != null) {
                carService.updateRide(car, p);
                return ResponseEntity.status(HttpStatus.OK).body(new Api("Updated successfully!", HttpStatus.OK));
            } else
                return addCar(p, errors);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
    /**
     * Delete a data by passing an id.
     * @param id id of the data
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Api> deleteCar(@PathVariable String id){
        boolean status;
        status = carService.deleteCar(id);
        return (!status) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("No data found!", HttpStatus.BAD_REQUEST))
                :          ResponseEntity.status(HttpStatus.OK).body(new Api("Successfully deleted!",HttpStatus.OK));
    }
    public void check(Errors errors) throws IllegalArgumentException{
        if (errors.hasErrors()){
            String error = errors.getFieldError().getDefaultMessage();
            throw new IllegalArgumentException(error);
        }
    }
}
