package com.diegwl.remedios.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/hello")
public class HelloWord {
    
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
