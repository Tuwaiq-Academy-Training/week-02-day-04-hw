package com.example.cardealership.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {

    @NotNull
    @Size(min = 2,message = " ID Must be more than 2 numbers")
    private String userid;

    @NotNull
    @Size(max =20, min = 4, message = " Name Must be more than 4 ")
    private String username;

    @NotNull
    @Size(max =20, min = 6, message = " Password Must be more than 6 ")
    private String password;

    @NotEmpty
    @Size(max =20, min = 4, message = " Name Must be more than 4 ")
    private Integer balance;

    private ArrayList<Car> carsowned;



}
