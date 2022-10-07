package com.fareye.training.controller;


import com.fareye.training.model.Car;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CarController {
    @GetMapping("/car")
    public String carData(){
        Car car = new Car();
        car.setId(1);
        car.setName("Maruti");
        car.setModel("Wagon R");
        return car.toString();
    }

    @PostMapping("/car")
    public String ceateCar(@RequestBody @Valid Car car, BindingResult bindingResult){
        bindingResult.hasErrors();
        return car.toString();
    }

    @GetMapping("/exceptionapi")
    public void exceptionDemo() throws Exception{
        throw new Exception("My exception");
    }

}
