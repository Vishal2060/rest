package com.example.demo.repository.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.example.demo.repository.jdbc.model.Student;

@Component
public class StudentRowMapper {

	public Student mapJdbcRowToStudent(ResultSet rs, int rowNum) throws SQLException {
		return Student.builder().id(rs.getInt("student_id")).name(rs.getString("student_name"))
				.age(rs.getInt("student_age")).build();
	}
}
