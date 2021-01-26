package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGeneerator implements CommandLineRunner {
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;

    public DataGeneerator(PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();

        User user = new User("kari",passwordEncoder.encode("kari123"),"USER",false,"");
        User user2 = new User("admin",passwordEncoder.encode("admin123"),"ADMIN",false,"ACCESS_TEST1,ACCESS_TEST2");
        User user3 = new User("manager",passwordEncoder.encode("manager123"),"MANAGER",false,"ACCESS_TEST1");
        List<User> users= Arrays.asList(user,user2,user3);

        userRepo.saveAll(users);

    }

}
