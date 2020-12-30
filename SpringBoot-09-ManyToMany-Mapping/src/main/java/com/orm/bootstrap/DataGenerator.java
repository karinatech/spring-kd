package com.orm.bootstrap;

import com.orm.entity.Post;
import com.orm.entity.Tag;
import com.orm.repo.PoostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {
    @Autowired
    PoostRepo postRepo;

    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("ORM","ManyToMany");
        Post post1 = new Post("MVC","Controlleer");

        Tag tag = new Tag("SpringBoot");
        Tag tag1 = new Tag("JPA");
        post.getTags().add(tag);
        post.getTags().add(tag1);

        tag.getPosts().add(post);
        tag1.getPosts().add(post);

        tag.getPosts().add(post1);
        post1.getTags().add(tag);
        postRepo.save(post);
        postRepo.save(post1);



    }
}
