package com.cybertek;

import com.cybertek.config.AppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext contaainer = new AnnotationConfigApplicationContext(AppConfig.class);
        Course cource = contaainer.getBean("java",Course.class);
        cource.getTeachingHours();
        ((AnnotationConfigApplicationContext)contaainer).close();
    }
}
