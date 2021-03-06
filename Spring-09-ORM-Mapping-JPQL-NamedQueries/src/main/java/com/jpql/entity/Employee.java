package com.jpql.entity;

import com.jpql.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
  @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", gender=" + gender +
                ", salary=" + salary +
                ", department=" + department +
                ", region=" + region +
                '}';
    }

    @ManyToOne
  @JoinColumn(name = "department")
    private Department department;

  @ManyToOne
  @JoinColumn(name = "region_id")
  private Region region;




}
