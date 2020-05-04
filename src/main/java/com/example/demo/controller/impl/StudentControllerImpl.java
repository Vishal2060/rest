package com.example.demo.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.jpa.domain.Student;
import com.example.demo.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentControllerImpl {

    private StudentService studentService;

    @GetMapping
    public List<Student> getList() {
        return studentService.getList();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping
    public void delete(Integer id) {
        studentService.delete(id);
    }
}