package com.crud.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.Entity.User;
import com.crud.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	//AddUser
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	//FetchUser
	public List<User> fetchAll() {
		return userRepo.findAll();
	}
	
	//FetchByEmail
	public User findByEmail(String email) {
		return userRepo. findByEmail(email);
		
	}
	
	//Update
	public User updateUser(User user,Integer id) {
		User update = userRepo.findById(id).get();
		update.setName(user.getName());
		update.setEmail(update.getEmail());
		return userRepo.save(update);
	}
	
	//DeleteUser
	public void deleteUser(Integer id) {
		this. userRepo.deleteById(id);
	}
}
