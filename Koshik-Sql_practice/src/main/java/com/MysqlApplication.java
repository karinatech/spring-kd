package com;

import com.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class MysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlApplication.class, args);
	}

}
