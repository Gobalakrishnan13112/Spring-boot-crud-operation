package com.crud.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.User;
import com.crud.Repository.UserRepo;

@Service
public class UserLoginService {

	@Autowired
	private UserRepo userRepo;
	
	public User loginUser(String email) {
		User login = userRepo.findById(id).get();
	}
}
