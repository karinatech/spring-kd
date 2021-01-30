package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@RestController

public class HomeController {
    final String URI="https://jsonplaceholder.typicode.com/users";
    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){
        ResponseEntity<User[]>responseEntity=restTemplate.getForEntity(URI,User[].class);
        return responseEntity.getBody();

    }
    @GetMapping(value = "/{id}")
    public User readUser(@PathVariable("id") Integer id){
        String URL=URI+"/{id}";
        User user = restTemplate.getForObject(URL,User.class,id);
        return user;
    }

    @GetMapping("test")
    public ResponseEntity<Object>consumePostsDummyApi(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","lTE5abbDxdjGplutvTuc");
        HttpEntity<String>entity=new HttpEntity<>(headers);
        ResponseEntity<Object>response=restTemplate.exchange("https://dummyapi.io/data/api/user?limit=10", HttpMethod.GET,entity,Object.class);
        return response;
    }
}
