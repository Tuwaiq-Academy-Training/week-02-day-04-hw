package com.example.springd4hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class User {
    @NotEmpty(message = "id can not be empty !")
    private String id;

    @NotEmpty(message = "user name can not be empty !")
    private String username;

    @NotEmpty(message = "password can not be empty !")
   // @Min(value = 5,message = "password must be more than 5 character")
    private String password;

    @NotNull(message = " should have balance !")
    private Integer balance;

    private ArrayList<Car> myCar;
}
