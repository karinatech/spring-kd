package com.cybertek.entity;

import com.cybertek.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")

@JsonIgnoreProperties(value = {"state","postalCode"}, ignoreUnknown = true)

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
    @JsonBackReference
    private User user;

    public Account(String name, String address, String country, String city, String state, Integer age, String postalCode, Role role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
