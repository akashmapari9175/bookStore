package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
}
