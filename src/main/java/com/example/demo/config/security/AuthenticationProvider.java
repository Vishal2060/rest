package com.example.demo.config.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProvider extends DaoAuthenticationProvider {

	AuthenticationProvider(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
        super.setPasswordEncoder(new BCryptPasswordEncoder(10));
        super.setHideUserNotFoundExceptions(false);
    }
}
