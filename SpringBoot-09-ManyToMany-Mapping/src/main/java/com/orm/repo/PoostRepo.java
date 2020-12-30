package com.orm.repo;

import com.orm.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoostRepo extends JpaRepository<Post,Long> {

}
