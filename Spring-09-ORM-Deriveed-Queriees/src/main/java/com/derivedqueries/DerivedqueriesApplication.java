package com.derivedqueries;

import com.derivedqueries.repo.DepartmentRepo;
import com.derivedqueries.repo.EmployeeRepo;
import com.derivedqueries.repo.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {
@Autowired
	RegionRepo regionRepo;
@Autowired
	DepartmentRepo departmentRepo;
@Autowired
	EmployeeRepo employeeRep;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}
@PostConstruct
	public void testRegions(){
	System.out.println("______Region Starts________");
	System.out.println("______RFind by country "+ regionRepo.findByCountry("Canada"));
	System.out.println("______RFind by country distinct "+regionRepo.findDistinctByCountry("Canada"));
	System.out.println("______RFind by country contains UNITED "+regionRepo.findByCountryContaining("United"));
	System.out.println("______RFind by country contains UNITED in order"+regionRepo.findByCountryContainingOrderByCountry("United"));
	System.out.println("______RFind top 2 by country  "+regionRepo.findTop2ByCountry("Canada"));
	System.out.println("______Find by department  "+departmentRepo.findByDepartment("Furniture"));
	System.out.println("______Find by division  "+departmentRepo.findByDivision("Health"));
	System.out.println("______Find by division ennd with ice  "+departmentRepo.findByDivisionEndingWith("ice"));
	System.out.println("______Find top 3 distinct by division contains Hea  "+departmentRepo.findDistinctTop3ByDivisionContains("Hea"));
	System.out.println("______Find all eemployes By Email not null "+employeeRep.findByEmailTrue());
	System.out.println("______Find all eemployes findByFirstNameAndLastNameOrEmail "+employeeRep.findByFirstNameAndLastNameOrEmail("Redford","Roberti", "lcasarolib@plala.or.jp"));
	System.out.println("______Find all eemployes findByFirstNameIsNot "+employeeRep.findByFirstNameIsNot("Kari"));
	System.out.println("______Find all eemployes findByLastNameStartingWith "+employeeRep.findByLastNameStartingWith("He"));
	System.out.println("______Find all eemployes findBySalaryGreaterThan "+employeeRep.findBySalaryGreaterThan(98000));
	System.out.println("______Find all eemployes findBySalaryEquals "+employeeRep.findBySalaryEquals(126588));
	System.out.println("______Find all eemployes findBySalaryGreaterThanEqualOrderBySalaryDesc "+employeeRep.findBySalaryGreaterThanEqualOrderBySalaryDesc(126588));
	System.out.println("______Find all eemployes findDistinctTop3BySalaryLessThan "+employeeRep.findDistinctTop3BySalaryLessThan(126588));
	System.out.println("______Find all eemployes findByEmailIsNull "+employeeRep.findByEmailIsNull());



}
}
