package com.cinemaapp.entity;

import com.cinemaapp.enums.MovieState;
import com.cinemaapp.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Movie extends BaseEntity{
    private String name;
    private String price;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated
    private MovieState state;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    private String summary;

    @ManyToMany
@JoinTable(name = "MovieGenreRel", joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre>ganreList;




}
