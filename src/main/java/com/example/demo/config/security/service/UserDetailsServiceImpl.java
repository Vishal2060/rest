package com.example.demo.config.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.config.security.model.User;
import com.example.demo.config.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("Username is not found");
        return user;
    }
}
