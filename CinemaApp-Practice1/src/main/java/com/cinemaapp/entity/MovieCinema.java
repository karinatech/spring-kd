package com.cinemaapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MovieCinema{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @ManyToOne
    private Movie movie;

}
