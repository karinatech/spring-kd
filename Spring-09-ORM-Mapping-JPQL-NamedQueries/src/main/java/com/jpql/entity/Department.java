package com.jpql.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="departments")

@NamedQuery(name = "Department.findKariDepartment",query = "SELECT d FROM Department d WHERE d.division=?1")
@NamedNativeQuery(name = "Department.countAllDepartments",query = "SELECT * FROM departments ",resultClass = Department.class)
public class Department{
    @Id
    private String department;
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department='" + department + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
