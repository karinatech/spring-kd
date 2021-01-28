package com.cybertek.entity;

import com.cybertek.enums.Status;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
