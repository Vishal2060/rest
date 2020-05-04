package com.example.demo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
