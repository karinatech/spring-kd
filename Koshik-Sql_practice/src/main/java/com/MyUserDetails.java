package com;

import com.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority>aauthorities;

public MyUserDetails(User user){
        this.userName=user.getUserNaame();
        this.password=user.getPassword();
        this.aauthorities=Arrays.stream(user.getRolee().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return aauthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
