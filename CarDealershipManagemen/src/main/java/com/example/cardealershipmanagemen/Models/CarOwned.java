package com.example.cardealershipmanagemen.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class CarOwned {

    private String carId;
    private String carModel;
    private String carType;
    private int carPrice;
}
