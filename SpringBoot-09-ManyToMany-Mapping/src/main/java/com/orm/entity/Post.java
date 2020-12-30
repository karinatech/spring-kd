package com.orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String desc;
@ManyToMany(cascade =CascadeType.ALL)
@JoinTable(name = "post_tag_rel", joinColumns = {@JoinColumn(name = "post_id")},inverseJoinColumns = {@JoinColumn(name="tag_id")})
private Set<Tag>tags=new HashSet<>();

    public Post(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}
