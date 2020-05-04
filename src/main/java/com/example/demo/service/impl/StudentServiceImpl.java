package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.repository.jpa.StudentRepository;
import com.example.demo.repository.jpa.domain.Student;
import com.example.demo.service.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<Student> getList() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
