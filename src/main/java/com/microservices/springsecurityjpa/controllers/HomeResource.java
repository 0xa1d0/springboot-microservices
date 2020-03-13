package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.MyUserDetailsService;
import com.microservices.springsecurityjpa.UserRepository;
import com.microservices.springsecurityjpa.models.AuthenticationRequest;
import com.microservices.springsecurityjpa.models.AuthenticationResponse;
import com.microservices.springsecurityjpa.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String home(){
        return("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin</h1>");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect Credentials", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
