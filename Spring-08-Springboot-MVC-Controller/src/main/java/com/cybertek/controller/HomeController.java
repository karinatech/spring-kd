package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String getRequestMapping(){

        return "home";
    }
    @RequestMapping("/kari")
    public String getRequestMapping1(){

        return "kari";
    }
    @RequestMapping("/maks")
    public String getRequestMapping2(){

        return "home";
    }
    @GetMapping("/spring")
    public String getMappingExample(){
        return "home";
    }
    @PostMapping("/spring")
    public String getMappingExampleSpring(){
        return "home";
    }
   // http://localhost:8080/home/%7Bname%7D
    @GetMapping("/home/{name}")
    public String pathVaariableExample(@PathVariable("name") String name){
        System.out.println("heeere is name "+ name);
        return "kari";
    }
    //http://localhost:8080/home/course?course=spring
    @GetMapping("home/course")
    public String requeestParamX(@RequestParam("course") String course){
        System.out.println("Course is : "+ course);
        return "kari";
    }
    //http://localhost:8080/home/course2?course2=MVC
    @GetMapping(value="home/course2")
    public String requeestParam2(@RequestParam("course2") String course2){
        System.out.println("Course is : "+ course2);
        return "kari";
    }
}
