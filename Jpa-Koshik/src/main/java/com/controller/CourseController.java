package com.controller;

import com.courses.CoursesService;
import com.models.Course;
import com.models.Topic;
import com.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @RequestMapping("/topic/courses")
    public List<Course> getAllCourses(){
      return coursesService.getAllCourses();

    }
    @GetMapping("/courses/{id}")
    public Optional<Course> getTopic(@PathVariable String id){
        return coursesService.getCourse(id);
    }
    @PostMapping("/courses")
    public void addTopic(@RequestBody Course course){
        coursesService.addTCourse(course);
    }

}
