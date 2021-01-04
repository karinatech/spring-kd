package com.jpql.repo;

import com.jpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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


    //Single named paarams
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") String salary);


    //Multipple named paarams
    @Query("SELECT e from Employee e where e.firstName=:name or e.salary=:salary")
    List<Employee>getEmployeeByFirstNaameOrSalary(@Param("name") String firstName,@Param("salary") int salary);
}
