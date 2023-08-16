package com.outside.service.impl;

import com.example.firstproject.service.Car;
import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car {

    @Override
    public String getHorsePower() {
        return "Seven Thirty Five Horse power";
    }
}
