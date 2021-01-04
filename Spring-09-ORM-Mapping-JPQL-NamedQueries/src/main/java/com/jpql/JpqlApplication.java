package com.jpql;

import com.jpql.entity.Employee;
import com.jpql.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {
@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}
@PostConstruct
	public void testEmployee(){
	System.out.println(employeeRepo.getEmployeeDetails());
	System.out.println(employeeRepo.getEmployeeSalary());
	System.out.println(employeeRepo.getEmployeeByEmailAndSalary("dtrail8@tamu.edu",82753));
}
}
