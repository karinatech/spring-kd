package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HemeResourse {
    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome Home </h1>");
    }
    @GetMapping("/user")
    public String useer(){
        return ("<h1>Welcome Usr!!!</h1>");

    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welccome Admin </h1>");
    }
}
