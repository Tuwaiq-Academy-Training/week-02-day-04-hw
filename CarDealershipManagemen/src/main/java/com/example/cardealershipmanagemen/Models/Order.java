package com.example.cardealershipmanagemen.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor @Data
public class Order {
    @NotEmpty (message = "id is required")
    private String id;
    @NotEmpty (message = "userid is required")
    private String userid;
    @NotEmpty (message = "carid is required")
    private String carid;
}
