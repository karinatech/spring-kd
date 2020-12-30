package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CybertekApplication {
    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(CybertekApplication.class, args);
    }

    @PostConstruct
    public void dataInit() {
        Car c1 = new Car("Leexus", "NX");
        Car c2 = new Car("Tesla", "C");
        Car c3 = new Car("Honda", "Civic");
        carRepository.save(c1);
        carRepository.save(c2);
    }
}
