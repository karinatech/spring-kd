package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Java implements Course {

    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : 20");
    }
@PostConstruct
    public void postConstruct(){
    System.out.println("Executing postConstruct");
}
@PreDestroy
    public void preDestroy(){
    System.out.println("Executing pre destroy");
}



}
