package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "course")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
@AllArgsConstructor
public class Course extends BaseEntity{

    private String name;
    @Column(columnDefinition = "text")
    private String description;

}
