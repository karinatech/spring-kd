package com.derivedqueries.repo;

import com.derivedqueries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    //Display all employees with eemail
    List<Employee>findByEmailTrue();
    //Display all eemployees with firstName and lastNamee also shaw employess with email address

    List<Employee>findByFirstNameAndLastNameOrEmail(String fnamee,String lname,String email);
    List<Employee>findByFirstNameIsNot(String fname);
List<Employee>findByLastNameStartingWith(String pattern);
List<Employee>findBySalaryGreaterThan(Integer salary);
List<Employee>findBySalaryEquals(Integer salary);
List<Employee>findByHireDateBetween(LocalDate startDate, LocalDate date);
List<Employee>findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);
List<Employee>findByEmailFalse();
List<Employee>findByEmailIsNull();



}
