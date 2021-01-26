package com.cybertek.security;

import com.cybertek.entity.User;
import com.cybertek.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPrincipalService implements UserDetailsService {
 private UserRepo userRepo;


    public UserPrincipalService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(s);
        UserPrincipal userPrincipal= new UserPrincipal(user);
  return userPrincipal;
    }
}
