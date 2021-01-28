package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value={"hibernate_Lazy_Initializer"},ignoreUnknown = true)
public class Location extends BaseEntity{
    private String name;
    private String country;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @Column(name = "postal_code")
    private String postalCode;
    private String address;
    private String city;
    private String state;


    public Location(String name, BigDecimal latitude, BigDecimal longitude, String postalCode, String country,String state, String city,String address) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.state=state;
    }
}
