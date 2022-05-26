package com.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Order {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "the id great than 2")
    private String id;
    @NotEmpty(message = "userid is required")
    @Length(min=10,max =10 ,message = "the user id equal 10")
    private String userid;
    @NotEmpty(message = "carid is required")
    @Size(min = 3,message = "the id great than 2")
    private String carid;
}
