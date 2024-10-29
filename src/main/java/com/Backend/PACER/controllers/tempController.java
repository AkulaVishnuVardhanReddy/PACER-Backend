package com.Backend.PACER.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.User;
import com.Backend.PACER.repositories.UserRepository;
import com.Backend.PACER.services.interfaces.UserService;

@RestController
public class tempController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/auth/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
//		userService.createUser(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("Saved successfully");
		
	}
}
