package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "class")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
@AllArgsConstructor
public class Class extends BaseEntity{

    private String name;
    private Long year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
