package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crud.Services.UserService;

@Controller
public class UserLoginController {

	@Autowired
	private UserService service;
	
	
}
