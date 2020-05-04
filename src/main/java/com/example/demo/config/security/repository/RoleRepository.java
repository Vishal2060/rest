package com.example.demo.config.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.config.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
