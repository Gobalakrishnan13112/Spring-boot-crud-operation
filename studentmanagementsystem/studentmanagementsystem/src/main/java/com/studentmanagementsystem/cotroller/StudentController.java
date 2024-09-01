package com.studentmanagementsystem.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentServiceImp;


@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImp service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/editForm/{id}")
	public String editStudentForm(@PathVariable(value = "id") long id, Model model) {
		Student student = service.getStudentById(id);
		model.addAttribute("student", student);
		return "edit_student";
	}
	
	@PostMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable(value = "id") long id, @ModelAttribute("student") Student student) {
		service.updateStudent(id, student);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") long id) {
		service.deleteStudentById(id);
		return "redirect:/";
	}
}