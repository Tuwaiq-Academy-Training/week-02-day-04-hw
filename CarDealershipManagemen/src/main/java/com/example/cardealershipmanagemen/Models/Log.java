package com.example.cardealershipmanagemen.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor @Data
public class Log {

   private String ID, message;

}
// ID, userid, carID