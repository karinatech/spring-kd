package com.cybertek.bootstrap;

import com.cybertek.entity.Product;
import com.cybertek.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private ProductRepo productRepo;

    public DataGenerator(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Product pc = new Product("Dell");
        Product laptop = new Product("Mac");
        Product iphaone = new Product("Pro");
        Product tablet = new Product("ipad");
        productRepo.save(pc);
        productRepo.save(laptop);
        productRepo.save(iphaone);
        productRepo.save(tablet);

    }
}
