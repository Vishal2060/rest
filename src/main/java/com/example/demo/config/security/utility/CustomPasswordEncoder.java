package com.example.demo.config.security.utility;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class CustomPasswordEncoder {
    public String convertPassword(String password) {
        return new BCryptPasswordEncoder(10).encode(password);
    }
}