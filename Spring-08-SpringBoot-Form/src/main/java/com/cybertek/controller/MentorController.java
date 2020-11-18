package com.cybertek.controller;

import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("mentor",new Mentor());
        List<String>batchList= Arrays.asList("B33", "B12", "B11", "B4", "B36", "B18", "B9", "B4");
        model.addAttribute("batchLiist",batchList);
        return "mentor/mentor-register";
    }
    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor")Mentor mentor){
        System.out.println(mentor.toString()+" here is my mentor --(*_*)--");
        return "mentor/mentor-confirmation";
    }

}
