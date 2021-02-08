package com.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }
}
