package com.learning.spring.boot.learning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${Welcome.Message}")
    private String Message;

    @GetMapping("/")
    public String HelloWorld(){
        return Message;
    }
}
