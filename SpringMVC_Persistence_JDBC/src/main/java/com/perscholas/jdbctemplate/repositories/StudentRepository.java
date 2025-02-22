package com.perscholas.jdbctemplate.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.jdbctemplate.models.Student;

public interface StudentRepository {
	Integer createStudent(Student student);
	Student getStudentById(Integer id) throws SQLException;
	List<Student> getAllStudents() throws ClassNotFoundException, IOException, SQLException;
	Boolean updateStudent(Student student);
	Boolean deleteStudent(Integer studentId);
}
