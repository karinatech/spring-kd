package com.cybertek;

import com.cybertek.interfaces.Cource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext container=SpringApplication.run(Spring07SpringBootDemoApplication.class, args);
		Cource cource=container.getBean("java",Cource.class);
		System.out.println(cource.getTeachingHours());
	}

}
