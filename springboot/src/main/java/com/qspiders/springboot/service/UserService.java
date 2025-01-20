package com.qspiders.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspiders.springboot.entity.Product;
import com.qspiders.springboot.entity.User;
import com.qspiders.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		user.setProducts(new ArrayList<Product>());
		return userRepository.save(user);
	}

	public User findUserByEmailAndPassword(String email, String password) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		if (user.isPresent())
			if (user.get().getEmail().equals(email) && user.get().getPassword().equals(password))
				return user.get();
		return null;
	}

	public User findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

}
