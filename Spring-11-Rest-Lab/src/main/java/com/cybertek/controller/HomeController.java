package com.cybertek.controller;

import com.cybertek.entity.Address;
import com.cybertek.entity.Parent;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.Teacher;
import com.cybertek.repo.AddressRepo;
import com.cybertek.repo.ParentRepo;
import com.cybertek.repo.StudentRepo;
import com.cybertek.repo.TeacherRepo;
import com.cybertek.serviceImpl.WeatherServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
WeatherServiceImpl weatherService;
TeacherRepo teacherRepo;
ParentRepo parentRepo;
StudentRepo studentRepo;
AddressRepo addressRepo;

    public HomeController(WeatherServiceImpl weatherService, TeacherRepo teacherRepo, ParentRepo parentRepo, StudentRepo studentRepo, AddressRepo addressRepo) {
        this.weatherService = weatherService;
        this.teacherRepo = teacherRepo;
        this.parentRepo = parentRepo;
        this.studentRepo = studentRepo;
        this.addressRepo = addressRepo;
    }

//    @GetMapping("/{city}")
//    public ResponseEntity<String>getWeather(@PathVariable("city") String city){
//        ResponseEntity<String> weather =weatherService.getWeather(city);
//        System.out.println(weatherService.getWeatherAsAString(weather)+" here is my weather in "+ city);
//return weather;
//    }

@GetMapping("/parents")
    public ResponseEntity<ResponseWrapper>getAllParents(){
        ResponseWrapper responseWrapper= new ResponseWrapper("Parents are successfully reetreivd ",parentRepo.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
}

@GetMapping("/teachers")
    public List<Teacher>getAllTeachers(){
        return teacherRepo.findAll();
}
@GetMapping("/students")
    public ResponseEntity<ResponseWrapper>readAllStudents(){
       return ResponseEntity.ok(new ResponseWrapper("students are successfully retreived ",studentRepo.findAll()));
}

@PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) throws Exception {
    Optional<Address>foundAAddress=addressRepo.findById(id);
    if(!foundAAddress.isPresent()){
        throw new Exception("Address does not excist");
    }
    address.setCurrentTemperature(new Address().getCurrentTemperature());
    address.setId(foundAAddress.get().getId());
    return addressRepo.save(address);

}
}

