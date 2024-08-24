package com.registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registration.Entity.User;
import com.registration.UserRepo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User userRegister(User user) {
        return repo.save(user);
    }
}
