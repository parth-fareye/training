package com.fareye.training.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    private Environment environment;

    @GetMapping("/properties")
    public String getProperties(){
        return environment.getProperty("server.port");
    }
}
