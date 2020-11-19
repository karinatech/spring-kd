package com.cybertek.controller;
import com.cybertek.dataGenerator.DataGenerator;
import com.cybertek.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("employee",new Employee());
            List<String> states = DataGenerator.getStateList();
        model.addAttribute("states",states);

        return "employee/register";

    }
    @PostMapping("/confirmation")
    public String confirmation(@ModelAttribute("employee") Employee employee,Model model){
model.addAttribute("employeeList", Arrays.asList(employee));
int birthYear= LocalDate.parse(employee.getBirthday()).getYear();
model.addAttribute("age", LocalDate.now().getYear()-birthYear);
        return "employee/confirmation";
    }

}
