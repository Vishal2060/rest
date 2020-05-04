package com.example.demo.repository.jdbc.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.jdbc.StudentDao;
import com.example.demo.repository.jdbc.mapper.StudentRowMapper;
import com.example.demo.repository.jdbc.model.Student;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {

	private final JdbcTemplate jdbcTemplate;
	private final StudentRowMapper studentRowMapper;

	private final String FIND_ALL_STUDENTS = "SELECT student_id, student_name, student_age from student";

	@Override
	public List<Student> findAll() {
		return jdbcTemplate.query(FIND_ALL_STUDENTS, studentRowMapper::mapJdbcRowToStudent);
	}

}
