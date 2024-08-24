package com.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.registration.Entity.User;
import com.registration.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String showRegisterForm(Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	    return "register_form"; 
	}

	@PostMapping("/register")
	public String userRegister(User user, RedirectAttributes redirectAttributes) {
	     service.userRegister(user);
	     redirectAttributes.addFlashAttribute("message", "User registered successfully!");
	     return "redirect:/";
	 }

	
}
