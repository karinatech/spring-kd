package com.cinemaapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Location extends BaseEntity{
    private String name;
    private Long latitude;
    private Long longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;
    @OneToMany
    private List<Cinema> cinemas;


}
