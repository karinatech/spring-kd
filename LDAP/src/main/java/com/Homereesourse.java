package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homereesourse {
    @GetMapping("/")
    public String home(){
        return "<h1>Hello i am at home</h1>";
    }
}
