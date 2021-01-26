package com.cybertek.security;

import com.cybertek.entity.User;
import com.cybertek.reepo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService {
    private UserRepo userRepo;

    public UserPrincipalDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);
        if (user==null){
            throw new UsernameNotFoundException("User does not exist");
        }

        UserPrincipal userPrincipal= new UserPrincipal(user);
        return userPrincipal;

    }
}
