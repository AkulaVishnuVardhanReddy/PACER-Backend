package com.Backend.PACER.controllers;

import com.Backend.PACER.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.repositories.UserRepository;
import com.Backend.PACER.services.UserService;

import java.util.Optional;

//@RestController
public class tempController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@GetMapping("/auth/get")
	public ResponseEntity<String> getAll() {
		return ResponseEntity.ok("Hello World");
	}
}
