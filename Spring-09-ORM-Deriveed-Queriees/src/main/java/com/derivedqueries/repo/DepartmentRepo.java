package com.derivedqueries.repo;

import com.derivedqueries.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,String> {
    List<Department> findByDepartment(String departmenet);
    List<Department>findByDivision(String division);
    List<Department>findByDivisionIs(String division);
    List<Department>findByDivisionEquals(String division);
    List<Department>findByDivisionEndingWith(String part);
    List<Department>findDistinctTop3ByDivisionContains(String part);


}
