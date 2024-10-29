package com.Backend.PACER.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.User;
import com.Backend.PACER.services.interfaces.UserService;

@RestController
@RequestMapping("/registrar")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/name")
	public ResponseEntity<String> getUser(){
		return ResponseEntity.ok("This is controller regisrter ");
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
		User modifiedUser = userService.updateUser(id, user);
		return modifiedUser !=null ?ResponseEntity.ok(modifiedUser) : 
			ResponseEntity.notFound().build();		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser = userService.createUser(user);
		return ResponseEntity.ok(createdUser);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = userService.getUserById(id);
		return user!=null ? ResponseEntity.ok(user) :
			ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
