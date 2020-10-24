package com.cybertek;

import com.cybertek.configs.ApplicationConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Course course=container.getBean("java",Course.class);
        course.getTeachingHours();
    }
}
