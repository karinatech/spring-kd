package com.jpql;

import com.jpql.entity.Employee;
import com.jpql.repo.DepartMentRepo;
import com.jpql.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {
@Autowired
	EmployeeRepo employeeRepo;
@Autowired
	DepartMentRepo departMentRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}
@PostConstruct
	public void testEmployee(){
//	System.out.println(employeeRepo.getEmployeeDetails());
//	System.out.println(employeeRepo.getEmployeeSalary());
//	System.out.println(employeeRepo.getEmployeeByEmailAndSalary("dtrail8@tamu.edu",82753));
//employeeRepo.updateEmployeeJpql(55);
//employeeRepo.updateEmployeeNativeQuerry(33);
//
//employeeRepo.retrieveEmployeeSalaryGreaterThan(1000);
//departMentRepo.retrieeDepaartmentByDivisioonContains("HO");
//	System.out.println(departMentRepo.findKariDepartment("Home"));
	System.out.println("Here is all my depoaartments "+departMentRepo.countAllDepartments());
}
}
