package com.cinemaapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Cinema extends BaseEntity {

    @Column(columnDefinition = "DATE")
    private LocalDateTime dateTime;
private String sponsoredName;
//    @OneToMany()
//    private List<MovieCinema> movieCinemas;
    @ManyToOne
    private Location location;
}
