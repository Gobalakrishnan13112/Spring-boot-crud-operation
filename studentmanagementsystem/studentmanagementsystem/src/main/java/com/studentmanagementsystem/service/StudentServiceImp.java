package com.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {	
	
	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		repository.save(student);
	}
	
	@Override
	public Student updateStudent(long id, Student student) {
		Student existingStudent = repository.findById(id).orElseThrow(() -> 
			new RuntimeException("Student not found for id :: " + id));
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setDepartment(student.getDepartment());
		existingStudent.setEmail(student.getEmail());
		return repository.save(existingStudent);
	}
	
	@Override
	public Student getStudentById(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new RuntimeException("Student not found for id :: " + id));
	}

	@Override
	public void deleteStudentById(long id) {
		repository.deleteById(id);	
	}
}