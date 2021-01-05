package com.jpql.repo;

import com.jpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    //Not equal
  @Query("select e from Employee e where e.salary<>?1")
  List<Employee>getEmployeeBySalaryNotEqual(int salary);

  //Like, Contains, Starts with endswith
  @Query("select e from Employee e where e.firstName like ?1")
  List<Employee>getEmployeeByFirstNameLike(String pattern);

  //Less than
  @Query("select e from Employee e where e.salary<?1")
  List<Employee>getEmployeeBySalaryLessThan(int salary);

  @Query("select e from Employee e where e.salary>?1")
  List<Employee>getEmployeesBySalaryGreaterThan(int salary);

  //Between
  @Query("select e from Employee e where e.salary between ?1 and ?2")
  List<Employee>getEmployeeeBySalaryBetween(int salary1, int salary2);
  //Beforee
  @Query("select e from Employee e where e.hireDate <?1")
  List<Employee>geetEmployeeByHireDateBeforeLocalDate(LocalDate date);
  @Query("select e from Employee e where e.email is null ")
  List<Employee>getEmployeeByEmailIsNull();

  @Query("select e from Employee e where e.email is not null ")
  List<Employee>getEmployeeByEmailIsNotNull();

  //sort salary
  @Query("select e from Employee e order by e.salary")
  List<Employee>getEmployeeBySalaryAscend();

  @Query("select e from Employee e order by e.salary desc ")
  List<Employee>getEmployeeBySalaryDesc();

  //NATIVE QUERY
  @Query(value = "select * from employees where salary=?1",nativeQuery = true)
  List<Employee>readEmployeeBySalary(int salary);


  //DDL operations
  @Modifying
  @Transactional
  @Query("update Employee e set e.email='admin.com' where e.id=:id")
  void updateEmployeeJpql(@Param("id")Integer id);

  @Modifying
  @Transactional
  @Query(value="update employees set email='admin@gmail.com'where id=:id",nativeQuery = true)
  void updateEmployeeNativeQuerry(@Param("id") Integer id);

//Named query
  List<Employee>retrieveEmployeeSalaryGreaterThan(Integer salary);




}
