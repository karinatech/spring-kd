package com.jpql.repo;

import com.jpql.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartMentRepo extends JpaRepository<Department,String> {

    @Query("select d from Department d where d.division in ?1")
    List<Department>getDepartmentByDivisionIn(List<String> division);


    List<Department>retrieveDepartmentByDivision(String division);


    @Query(nativeQuery = true)
    List<Department>retrieeDepaartmentByDivisioonContains(String pattern);

    List<Department>findKariDepartment(String division);

    @Query(nativeQuery = true)
    List<Department> countAllDepartments();

}
