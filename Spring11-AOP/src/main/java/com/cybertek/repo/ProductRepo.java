package com.cybertek.repo;

import com.cybertek.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Override
Optional<Product>findById(Long id);
}
