package com.cinemapp.entity;

import com.cinemapp.enums.Statee;
import com.cinemapp.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Movie extends BaseEntity{

    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Statee state;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;

    public Movie(String name, BigDecimal price, Type type, Statee state, LocalDate releaseDate, Integer duration, String summary) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
    }
    @ManyToMany
            @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
   private List<Genre>ganres= new ArrayList<>();
}
