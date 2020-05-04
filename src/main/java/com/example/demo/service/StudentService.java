package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.jpa.domain.Student;

public interface StudentService {
    List<Student> getList();
    Student create(Student student);
    void update(Student student);
    void delete(Integer id);
}
