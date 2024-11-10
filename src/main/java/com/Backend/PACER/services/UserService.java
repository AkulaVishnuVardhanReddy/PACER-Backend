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

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User updateUser(Long id, User userDetails) {
		return userRepository.findById(id)
				.map(existingUser -> {
					// Only set the fields that need to be updated, or just pass the userDetails
					userDetails.setId(existingUser.getId());  // Ensure the ID is set, as it's not in the request body
					return userRepository.save(userDetails);  // Directly save the modified user
				})
				.orElse(null); // Return null if the user is not found
	}

}

