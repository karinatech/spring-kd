package com.cinemapp.entity;

import com.cinemapp.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity{
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role =Role.USER;

    @OneToOne(mappedBy = "account")
    private User user;



}
