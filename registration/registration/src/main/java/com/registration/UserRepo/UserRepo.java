package com.registration.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
