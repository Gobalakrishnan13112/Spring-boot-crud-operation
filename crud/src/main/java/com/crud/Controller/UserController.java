package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.User;
import com.crud.Services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	//AddUser
	@PostMapping("/add")
	public String addUser(User user) {
		service.addUser(user);
		return"User Added";
	}
	
	//FetchUser
	@GetMapping("/fetch")
	public List<User> fetchAll() {
		return service.fetchAll();
	}
	
	//FetchbyEmail
	@GetMapping("/fetchemail/{email}")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		service.updateUser(user, id);
		return "User Data Updated";
	}
	
	//DeleteUser
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		service.deleteUser(id);
		return "User Deleted";
	}
}
