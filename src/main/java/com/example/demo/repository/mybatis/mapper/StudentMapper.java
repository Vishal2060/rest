package com.example.demo.repository.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.repository.mybatis.model.Student;

@Mapper
public interface StudentMapper {
	
	String SELECT_QUERY = "SELECT student_id as id, student_name as name, student_age as age FROM student WHERE student_id = #{id}"; 
	
    @Select(SELECT_QUERY)
    Student getArticle(@Param("id") Long id);
}
