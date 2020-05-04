package com.example.demo.config.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.config.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
