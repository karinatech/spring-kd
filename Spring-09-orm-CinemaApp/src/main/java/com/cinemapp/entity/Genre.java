package com.cinemapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Genre extends BaseEntity{

    private String name;

    public Genre(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "ganres")
    private List<Movie>movies= new ArrayList<>();


}
