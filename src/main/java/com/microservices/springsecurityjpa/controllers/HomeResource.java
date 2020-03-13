package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.MyUserDetailsService;
import com.microservices.springsecurityjpa.UserRepository;
import com.microservices.springsecurityjpa.models.AuthenticationRequest;
import com.microservices.springsecurityjpa.models.AuthenticationResponse;
import com.microservices.springsecurityjpa.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    Logger logger = LoggerFactory.getLogger(HomeResource.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String home(){
        logger.info("Home method accessed");
        return("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        logger.info("User method accessed");
        return("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        logger.info("Admin method accessed");
        return("<h1>Welcome Admin</h1>");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            logger.info("Autentication method accessed");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            logger.error("Incorrect Credentials");
            throw new Exception("Incorrect Credentials", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        logger.info("Autentication response");

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
