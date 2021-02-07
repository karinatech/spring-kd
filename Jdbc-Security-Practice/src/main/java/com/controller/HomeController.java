package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String goHome(){
        return ("<h1> Hello its home!</h1>");
    }
    @GetMapping("/user")
    public String goToUser(){
        return ("<h1> Hello User!</h1>");
    }
    @GetMapping("/admin")
    public String goToAdmin(){
        return ("<h1> Hello Admin!</h1>");
    }
}
