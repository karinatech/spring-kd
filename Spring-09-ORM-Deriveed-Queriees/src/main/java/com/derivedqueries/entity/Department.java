package com.derivedqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="departments")

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
