package com.qspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.springboot.entity.User;
import com.qspiders.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/users")
	protected User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping(path="/users")
	protected List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@PostMapping(path = "/users/auth")
	protected String findUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		User authenticatedUser = userService.findUserByEmailAndPassword(email, password);
		if (authenticatedUser != null)
			return "User is authenticated";
		else
			return "Invalid email or password";
	}
}