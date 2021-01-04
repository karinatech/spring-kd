package com.derivedqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "regions")
public class Region extends BaseEntity{

    private String region;
    private String country;

    @Override
    public String toString() {
        return "Region{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
