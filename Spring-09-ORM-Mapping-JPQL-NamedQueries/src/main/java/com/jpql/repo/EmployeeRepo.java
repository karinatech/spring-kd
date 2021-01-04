package com.jpql.repo;

import com.jpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
@Query("SELECT e FROM Employee e WHERE e.email='amcnee1@google.es'")
    Employee getEmployeeDetails();
@Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
Integer getEmployeeSalary();
//Single bind param
    @Query("SELECT e FROM Employee e WHERE e.email=?1")
  Optional<Employee> getEmployeeByEmail(String email);
    //Multiple bind param
    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email, int salary);
}
