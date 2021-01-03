package com.cinemapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.description.type.TypeList;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Ticket extends BaseEntity{
    @Column(name = "seat_number")
    private Integer seatNumber;
    private Integer rowNumber;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_cinema_id")
private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private User user;


}
