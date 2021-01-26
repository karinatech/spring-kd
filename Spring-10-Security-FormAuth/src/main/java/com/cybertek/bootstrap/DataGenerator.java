package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.reepo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGenerator implements CommandLineRunner {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        //Deelete all
        this.userRepo.deleteAll();

        //Create users
        User employee = new User("kari",passwordEncoder.encode("kari123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");
        List<User>users= Arrays.asList(employee,admin,manager);

        userRepo.saveAll(users);

    }

}
