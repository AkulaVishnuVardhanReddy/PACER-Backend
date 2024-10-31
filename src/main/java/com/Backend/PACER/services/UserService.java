package com.Backend.PACER.services;

import com.Backend.PACER.entities.User;
import com.Backend.PACER.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}

	public User updateUser(Long id , User user) {
		if(userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		}
		return null;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}

