package com.controller;

import com.JwtUtil;
import com.models.AuthenticationResponse;
import com.models.AuthentificationRequst;
import com.services.MyUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloResourse {

    private AuthenticationManager authenticationManager;
    private MyUserDetailsService userDetailsService;
    private JwtUtil util;

    public HelloResourse(AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil util) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.util = util;
    }

    @GetMapping("hello")
    public String hello() {
        return ("<h1> Hello world </h1>");
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthentificationRequst aauthentificationRequst) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(aauthentificationRequst.getUserName(),
                            aauthentificationRequst.getPassWord())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password " + e);
        }
final UserDetails userDetails=userDetailsService.loadUserByUsername(aauthentificationRequst.getUserName());
        final String jwt=util.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
