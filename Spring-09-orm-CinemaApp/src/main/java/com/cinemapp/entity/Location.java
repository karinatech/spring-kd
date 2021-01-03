package com.cinemapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Location extends BaseEntity{
    private String name;
    private String country;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String postalCode;
    private String address;
    private String city;

    public Location(String name, String country, BigDecimal latitude, BigDecimal longitude, String postalCode, String address, String city) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
    }
}
