package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "userz")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean isActive;
    private String roles;
    private Boolean expired;
    private String permissions;

    public User(String username, String password, String roles, Boolean expired, String permissions) {
        this.username = username;
        this.password = password;
        this.isActive = true;
        this.roles = roles;
        this.expired = expired;
        this.permissions = permissions;
    }

    public List<String>getRoleList(){
       if(this.roles.length()>0){
           return Arrays.asList(this.roles.split(","));
       }
       return new ArrayList<>();
    }
    public List<String>getPermissions(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
