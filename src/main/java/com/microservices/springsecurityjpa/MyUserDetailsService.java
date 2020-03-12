package com.microservices.springsecurityjpa;

import com.microservices.springsecurityjpa.models.MyUserDetails;
import com.microservices.springsecurityjpa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String use_username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(use_username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + use_username));

        return user.map(MyUserDetails::new).get();
    }
}
