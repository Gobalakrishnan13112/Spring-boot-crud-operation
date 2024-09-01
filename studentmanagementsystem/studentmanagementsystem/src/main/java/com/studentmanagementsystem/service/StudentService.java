package com.studentmanagementsystem.service;

import java.util.List;
import com.studentmanagementsystem.entity.Student;


public interface StudentService {

	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student updateStudent(long id,Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);
}
