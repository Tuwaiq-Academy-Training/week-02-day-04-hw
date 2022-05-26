package com.example.springd4hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Log {

    private String id;
    private String msg;
    private Order orderMsg;

}
