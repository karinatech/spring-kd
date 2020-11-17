package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorControler {
    @GetMapping("/list")
    public String showTable(Model model){
        List<Mentor>mentorList=new ArrayList<>();
        mentorList.add(new Mentor("Mike","Doe", Gender.FEMALE,33));
        mentorList.add(new Mentor("Joe","Arm", Gender.MALE,48));
        mentorList.add(new Mentor("Jack","Sparrow", Gender.MALE,56));
        mentorList.add(new Mentor("Emily","Strong", Gender.FEMALE,23));
        model.addAttribute("mentors",mentorList);

        return "mentor/mentorList";
    }

}
