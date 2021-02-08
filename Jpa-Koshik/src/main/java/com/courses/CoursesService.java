package com.courses;

import com.models.Course;
import com.models.Topic;
import com.repo.CourseRepo;
import com.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    @Autowired
    private CourseRepo courseRepo;


    public List<Course>getAllCourses(){
        List<Course>list = new ArrayList<>();
        courseRepo.findAll()
                .forEach(list::add);
        return list;
    }
    public Optional<Course> getCourse(String id){
        return courseRepo.findById(id);
    }
    public void addTCourse(Course course){
        courseRepo.save(course);
    }
    public void deleteCourse(String id){
        courseRepo.deleteById(id);
    }


}
