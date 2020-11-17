package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/welcome")
    public String homePage(Model model){
        String subject="Collections";
        String course="Java developer";
        int studentID= new Random().nextInt(1000);
        model.addAttribute("name","Kari");
        model.addAttribute("subject",subject);
        model.addAttribute("course",course);
        model.addAttribute("studentID",studentID);

        List<Integer>nums = new ArrayList<>();
        nums.add(4);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        model.addAttribute("numbers",nums);

        LocalDate bday = LocalDate.now().minusYears(28).minusDays(4);
        model.addAttribute("birthdate",bday);
        Student student= new Student(123, "jack", "Sparrow");
        model.addAttribute("student",student);

        return "student/welcome";
    }
    @GetMapping("/register")
    public String welcomePage2(){
        return "student/register";

    }


}
