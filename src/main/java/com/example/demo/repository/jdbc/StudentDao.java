package com.example.demo.repository.jdbc;

import java.util.List;

import com.example.demo.repository.jdbc.model.Student;

public interface StudentDao {
	List<Student> findAll();
}
